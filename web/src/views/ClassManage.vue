<template>
  <a-layout>
    <a-layout-content :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">
      <a-space size="small">
        <p>
          <a-button type="primary" @click="handleQuery({page:0, size:20})" size="large">刷新</a-button>
        </p>
        <p>
          <a-button type="primary" @click="add" size="large">新增</a-button>
        </p>
      </a-space>

      <a-table
          :columns="columns"
          :rowKey="record => record.id"
          :data-source="level1"
          :pagination="false"
          :loading="loading"
      >

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
      title="新增分类"
      v-model:visible="modelVisible"
      :confirm-loading="modelLoading"
      @ok="handleModelOK"
  >
    <a-form :model="category" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">

      <a-form-item label="名称">
        <a-input v-model:value="category.name" />
      </a-form-item>

      <a-form-item label="父分类">
<!--        <a-input v-model:value="category.parent"/>-->
        <a-select
            ref="select"
            v-model:value="category.parent"
        >
          <a-select-option value="0">
            无
          </a-select-option>
          <a-select-option v-for="c in level1" :key="c.id" :value="c.id" :disabled="category.id === c.id">
            {{c.name}}
          </a-select-option>
        </a-select>
      </a-form-item>

      <a-form-item label="描述">
        <a-textarea v-model:value="category.description" showCount :maxlength="100" />
      </a-form-item>

    </a-form>
  </a-modal>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from 'vue';
import axios from "axios";
import {Tool} from "@/util/tool";
import {message} from "ant-design-vue";

export default defineComponent({
  name: 'Statistic',
  components: {
  },
  setup() {
    const hierarchical_class = ref();
    const level1 = ref();
    const loading = ref(false);

    const columns = [
      {
        title: '名称',
        key: 'name',
        dataIndex: 'name'
      },
      {
        title: '描述',
        key: 'description',
        dataIndex: 'description'
      },
      {
        title: 'Action',
        key: 'action',
        slots: { customRender: 'action' }
      }
    ];

    const handleQuery = (params: any) => {
      loading.value = true
      axios.get("/category/list", {
        params: {
          page: params.page,
          size: params.size
        }
      }).then((response)=>{
        loading.value = false;
        const data = response.data;
        if (data.success) {
          hierarchical_class.value = data.content.list;
          console.log("层次",hierarchical_class.value)
          level1.value = [];
          level1.value = Tool.array2Tree(hierarchical_class.value, 0);
          console.log("level1:", level1.value)
        } else {
          message.error(data.message);
        }
      })
    }

    /**
     * 表单
     */
    const category = ref({});
    const modelVisible = ref(false);
    const modelLoading = ref(false);
    const handleModelOK = () => {
      modelLoading.value = true;
      axios.post("/category/save", category.value).then((response) => {
        modelLoading.value = false;
        const data = response.data; // data = CommonResp
        if (data.success) {
          modelVisible.value = false;
          //重新加载列表
          handleQuery(
              {
                page: 0,
                size: 10
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
            page: 0,
            size: 10
          });
    };

    /**
     * 编辑页面
     */
    const edit = (record: any) => {
      modelVisible.value = true;
      category.value = Tool.copy(record);
    };

    const add = () => {
      modelVisible.value = true;
      category.value = {};
    };

    const del = (id: number) => {
      axios.delete("/category/delete/" + id).then((response) => {
        const data = response.data; // data = CommonResp
        console.log(data)
        if (data.success) {
          //重新加载列表
          handleQuery(
              {
                page: 0,
                size: 20
              });
        }
      });
    };


    onMounted(()=>{
      handleQuery(
          {
            page: 0,
            size: 20
          });
    })

    return {
      level1,
      columns,
      loading,
      edit,
      modelVisible,
      modelLoading,
      handleModelOK,
      category,
      add,
      del,
      value,
      onSearch,
      handleQuery
    }
  }
});
</script>
