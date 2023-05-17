<template>
  <a-layout>
    <a-layout-content :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">
      <a-space size="small">
        <p>
          <a-button type="primary" @click="handleQuery({page:pagination.current, size:pagination.pageSize})" size="large">刷新</a-button>
        </p>
        <p>
          <a-button type="primary" @click="add" size="large">新增</a-button>
        </p>
      </a-space>

      <a-table
          :columns="columns"
          :rowKey="record => record.id"
          :data-source="knowledges"
          :pagination="pagination"
          :loading="loading"
          @change="handleTableChange"
      >
        <template #KBID = "{ text: id }" >
          <span>K-{{id}}</span>
        </template>

        <template #state="{ text: state }">
          <span>
<!--            <a-badge :status = "state === 1 ? 'success' : 'error'" :text="state === 1 ? '运行中' : '已过期'"/>-->
            <a-badge v-if="state === 0" status = "error" text="已过期"/>
            <a-badge v-else-if="state === 1" status = "success" text="运行中"/>
            <a-badge v-else-if="state === 2" status = "processing" text="审核中"/>
          </span>
        </template>

        <template #tags="{ text: tags }">
          <span>
            <a-tag
                v-for="tag in tags"
                :key="tag"
                :color="tag === '无' ? 'volcano' : tag === tags[0] ? 'geekblue' : 'green'"
            >
              {{ tag.toUpperCase() }}
            </a-tag>
          </span>
        </template>
        <template v-slot:action="{ record }">
          <span>
            <a-space size="small">
              <a-button type="primary" @click="showKnowledge(record)">详情</a-button>
              <a-button type="primary" @click="edit(record)">编辑</a-button>
              <a-popconfirm
                  title="删除后不可恢复，确认删除？"
                  ok-text="是"
                  cancel-text="否"
                  @confirm="del(record.id)"
              >
                <a-button type="primary" danger>删除</a-button>
              </a-popconfirm>
            </a-space>
          </span>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>

  <a-drawer
      title="风险知识详情"
      v-model="knowledge"
      width="550"
      :closable="false"
      :visible="knowledgeDrawerVisible"
      @close="onDrawerClose"
  >
    <a-descriptions title="Knowledge Info" size="small" bordered :column="2">
      <a-descriptions-item label="知识编号" :span="3">K-{{knowledge.id}}</a-descriptions-item>
      <a-descriptions-item label="风险知识名称">{{knowledge.name}}</a-descriptions-item>
      <a-descriptions-item label="风险知识类别">{{knowledge.category}}</a-descriptions-item>
      <a-descriptions-item label="生效时间">{{knowledge.activateTime}}</a-descriptions-item>
      <a-descriptions-item label="失效时间" :span="2">{{knowledge.expireTime}}</a-descriptions-item>
      <a-descriptions-item label="运行状态" :span="3">
        <a-badge v-if="knowledge.state === 0" status = "error" text="已过期"/>
        <a-badge v-else-if="knowledge.state === 1" status = "success" text="运行中"/>
        <a-badge v-else-if="knowledge.state === 2" status = "processing" text="审核中"/>
      </a-descriptions-item>
      <a-descriptions-item label="创建者">{{knowledge.manager}}</a-descriptions-item>
      <a-descriptions-item label="关联业务员1">{{knowledge.reviewer1}}</a-descriptions-item>
      <a-descriptions-item label="关联业务员2">{{knowledge.reviewer2}}</a-descriptions-item>
      <a-descriptions-item label="关联业务员3">{{knowledge.reviewer3}}</a-descriptions-item>
      <a-descriptions-item label="知识数量" :span="3">{{knowledge.number}}</a-descriptions-item>
      <a-descriptions-item label="参数列表">
        {{schemaString}}
      </a-descriptions-item>
    </a-descriptions>
    <a-button type="primary" @click="showKnowledgeList">查看详细知识表单</a-button>
    <a-drawer
        title="知识表单详情"
        width="940"
        :closable="false"
        :visible="knowledgeListDrawerVisible"
        @close="onListDrawerClose"
    >
      <a-table :columns="schemaColumns"
               :data-source="knowledgeItems">

        <template v-slot:action> </template>
      </a-table>

    </a-drawer>
  </a-drawer>

  <a-modal
      v-model:visible="modalReviewVisible"
      title="提交审核成功"
      @ok="handleReviewOK"
      width="80%"
      wrapClassName="full-modal"
  >
    <p>Some contents...</p>
    <p>Some contents...</p>
    <p>Some contents...</p>
  </a-modal>

  <a-modal
      title="新增风险知识"
      v-model:visible="modelVisible"
      :confirm-loading="modelLoading"
      @ok="handleModelOK"
  >
    <a-form :model="knowledge" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">

      <a-form-item label="名称">
        <a-input v-model:value="knowledge.name" />
      </a-form-item>

      <a-form-item label="分类">
<!--        <a-input v-model:value="category.parent"/>-->
        <a-select
            ref="select"
            v-model:value="knowledge.category"
            placeholder="Please select"
        >
          <a-select-option value="0">
            无
          </a-select-option>
          <a-select-option v-for="c in categories" :key="c.id" :value="c.name">
            {{c.name}}
          </a-select-option>
        </a-select>
      </a-form-item>

      <a-form-item label="管理者">
        <a-select
            v-model:value="knowledge.managers"
            mode="multiple"
            style="width: 100%"
            placeholder="Please select"
        >
          <a-select-option v-for="u in users" :key="u.id" :value="u.name">
            {{u.name}}
          </a-select-option>
        </a-select>
      </a-form-item>

      <a-form-item label="生效时间">
        <a-input v-model:value="knowledge.activateTime" />
      </a-form-item>

      <a-form-item label="失效时间">
        <a-input v-model:value="knowledge.expireTime" />
      </a-form-item>

    </a-form>
  </a-modal>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from 'vue';
import axios from "axios";
import {Tool} from "@/util/tool";
import {message} from "ant-design-vue";
import {useRoute} from "vue-router";

export default defineComponent({
  name: 'Statistic',
  components: {
  },
  setup() {
    const knowledges = ref();
    const knowledge = ref();
    const loading = ref(false);
    const route = useRoute();
    const categories = ref();
    const users = ref()
    const modalReviewVisible = ref(false);

    const pStyle = {
      fontSize: '16px',
      color: 'rgba(0,0,0,0.85)',
      lineHeight: '24px',
      display: 'block',
      marginBottom: '16px',
    };
    const pStyle2 = {
      marginBottom: '24px',
    };

    const pagination = ref({
      current: 0,
      pageSize: 20,
      total: 1
    });

    const columns = [
      {
        title: 'ID',
        key: 'id',
        dataIndex: 'id',
        slots: { customRender: 'KBID' }
      },
      {
        title: '名称',
        key: 'name',
        dataIndex: 'name'
      },
      {
        title: '状态',
        key: 'state',
        dataIndex: 'state',
        slots: { customRender: 'state' }
      },
      {
        title: '风险类别',
        key: 'category',
        dataIndex: 'category'
      },
      {
        title: '管理者',
        key: 'managers',
        dataIndex: 'managers',
        slots: { customRender: 'tags' },
      },
      {
        title: '生效时间',
        key: 'activateTime',
        dataIndex: 'activateTime'
      },
      {
        title: '失效时间',
        key: 'expireTime',
        dataIndex: 'expireTime'
      },
      {
        title: '数目',
        key: 'number',
        dataIndex: 'number'
      },
      {
        title: 'Action',
        key: 'action',
        slots: { customRender: 'action' }
      }
    ];

    const getCategories = () => {
      loading.value = true
      axios.get("/category/list", {
        params: {
          page: 0,
          size: 1000
        }
      }).then((response)=>{
        loading.value = false;
        const data = response.data;
        if (data.success) {
          categories.value = data.content.list;
          console.log("加载类别：", categories.value)
        } else {
          message.error(data.message);
        }
      })
    }

    const getUsers = () => {
      loading.value = true
      axios.get("/user/list", {
        params: {
          page: 0,
          size: 1000
        }
      }).then((response)=>{
        loading.value = false;
        const data = response.data;
        if (data.success) {
          users.value = data.content.list;
          console.log("加载用户：", users.value)
        } else {
          message.error(data.message);
        }
      })
    }

    const handleQuery = (params: any) => {
      loading.value = true
      axios.get("/knowledge/management/list", {
        params: {
          page: params.page,
          size: params.size
        }
      }).then((response)=>{
        loading.value = false;
        const data = response.data;
        if (data.success) {
          knowledges.value = Tool.copyKnowledges(data.content.list);
          console.log("知识列表：",knowledges.value)

          pagination.value.current = params.page;
          pagination.value.total = data.content.total;
        } else {
          message.error(data.message);
        }
      })
    }

    /**
     * 点击页码时触发
     */
    const handleTableChange = (pagination: any) => {
      console.log("看看自带的分页参数：" + pagination);
      handleQuery({
        page: pagination.current,
        size: pagination.pageSize
      });
    };

    /**
     * 表单
     */

    const modelVisible = ref(false);
    const modelLoading = ref(false);
    const handleModelOK = () => {
      modelLoading.value = true;
      const newKL = Tool.reverseKnowledge(knowledge.value);
      // console.log("新增知识：", newKL)
      axios.post("/knowledge/management/save", newKL).then((response) => {
        modelLoading.value = false;
        const data = response.data; // data = CommonResp
        if (data.success) {
          modelVisible.value = false;
          //重新加载列表
          handleQuery(
              {
                page: pagination.value.current,
                size: pagination.value.pageSize
              }
          );
          message.success("修改成功！")
        } else {
          message.error(data.message);
        }
      });
    };

    const value = ref<string>();
    const onSearch = (searchValue: string) => {
      console.log(searchValue)
      handleQuery(
          {
            page: pagination.value.current,
            size: pagination.value.pageSize
          });
    };

    const showReviewModal = () => {
      modalReviewVisible.value = true
    }

    const handleReviewOK = () => {
      modalReviewVisible.value = false
    }

    /**
     * 编辑页面
     */
    const edit = (record: any) => {
      getCategories();
      getUsers();
      modelVisible.value = true;
      console.log("edit record:", record)
      knowledge.value = Tool.copy(record);
    };

    const add = () => {
      getCategories();
      getUsers();
      modelVisible.value = true;
      knowledge.value = {};
    };

    const del = (id: number) => {
      axios.delete("/knowledge/management/delete/" + id).then((response) => {
        const data = response.data; // data = CommonResp
        console.log(data)
        if (data.success) {
          //重新加载列表
          handleQuery(
              {
                page: pagination.value.current,
                size: pagination.value.pageSize
              });
        }
      });
    };

    /***
     * 使用抽屉展示知识详情
     */
    const knowledgeDrawerVisible = ref(false);
    const knowledgeListDrawerVisible = ref(false);

    const schemaString = ref()
    const getSchemas = (kid: number) => {
      axios.get("/knowledge/schema/search/" + kid).then((response)=>{
        const data = response.data;
        if (data.success) {
          schemaString.value = []
          schemaString.value = Tool.copy(Tool.copy(data.content)[0].schema);
          console.log("schema: ", schemaString.value)
        } else {
          message.error("加载参数列表失败")
        }
      })
    }

    const showKnowledge = (record: any) => {
      knowledge.value = Tool.reverseKnowledge(record);
      getSchemas(knowledge.value.id)
      knowledgeDrawerVisible.value = true;
      console.log("当前选中：", knowledge.value)
    }

    const showKnowledgeList = (record: any) => {
      handleQueryKnowledgeItems();
      generateSchemaColumns();
      knowledgeListDrawerVisible.value = true;
    }

    const knowledgeItems = ref()
    const schemaColumns: any = []
    const generateSchemaColumns = () => {
      schemaColumns.splice(0, schemaColumns.length)
      console.log("dynamic table head before:",schemaColumns, schemaString.value.length)
      if (schemaString.value.length > 0) {
        const arr = JSON.parse(schemaString.value)
        console.log("schema length:", arr.length)
        for (let i = 0, len = arr.length; i< len; i++){
          schemaColumns.push({
            title: arr[i],
            key: arr[i],
            dataIndex: arr[i]
          })
        }
        schemaColumns.push({
          title: "Action",
          key: 'action',
          slots: { customRender: 'action' }
        })
      }
      console.log("dynamic table head:",schemaColumns)
    }

    const handleQueryKnowledgeItems = () => {
      console.log("quert items")
    }


    const onDrawerClose = () => {
      knowledgeDrawerVisible.value = false;
    }

    const onListDrawerClose = () => {
      knowledgeListDrawerVisible.value = false;
    }

    onMounted(()=>{
      const name = route.query.name
      console.log("current search ", name);
      handleQuery(
          {
            page: 0,
            size: 20
          });
    })


    return {
      knowledgeItems,
      schemaColumns,
      knowledges,
      knowledge,
      columns,
      loading,
      edit,
      modelVisible,
      modelLoading,
      handleModelOK,
      add,
      del,
      value,
      onSearch,
      handleQuery,
      pagination,
      handleTableChange,
      categories,
      users,
      showKnowledge,
      knowledgeDrawerVisible,
      knowledgeListDrawerVisible,
      onDrawerClose,
      showKnowledgeList,
      onListDrawerClose,
      pStyle,
      pStyle2,
      modalReviewVisible,
      showReviewModal,
      handleReviewOK,
      schemaString
    }
  }
});
</script>
