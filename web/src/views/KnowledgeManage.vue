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
        <template #state="{ text: state }">
          <span>
            <a-badge :status = "state === 1 ? 'success' : 'error'" :text="state === 1 ? '运行中' : '已过期'"/>
          </span>
        </template>

        <template #tags="{ text: tags }">
          <span>
            <a-tag
                v-for="tag in tags"
                :key="tag"
                :color="tag === '无' ? 'volcano' : tag.length > 5 ? 'geekblue' : 'green'"
            >
              {{ tag.toUpperCase() }}
            </a-tag>
          </span>
        </template>
        <template v-slot:action="{ record }">
          <span>
            <a-space size="small">
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

    const pagination = ref({
      current: 0,
      pageSize: 20,
      total: 1
    });

    const columns = [
      {
        title: 'ID',
        key: 'id',
        dataIndex: 'id'
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
          knowledges.value = Tool.copyKnowledges(data.content);
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
      console.log("新增知识：", newKL)
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
      users
    }
  }
});
</script>
