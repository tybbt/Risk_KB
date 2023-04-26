<template>
  <a-layout-sider v-model:collapsed="collapsed" collapsible>
    <div class="logo">
        <img src="/image/KBlogo.png" />
    </div>
    <a-menu theme="dark" v-model:selectedKeys="selectedKeys" mode="inline">
      <a-sub-menu key="kb">
        <template #title>
              <span>
                <ReadOutlined />
                <span>风险知识</span>
              </span>
        </template>
        <a-menu-item v-for="item in categories" :key="item.id">
            <span>
              <DropboxOutlined />
              {{item.name}}
            </span>
        </a-menu-item>
      </a-sub-menu>


      <a-menu-item key="statistic">
        <LineChartOutlined />
        <span>查看统计数据</span>
      </a-menu-item>

      <a-sub-menu key="class_manage">
        <template #title>
              <span>
                <ApartmentOutlined />
                <span>风险类别管理</span>
              </span>
        </template>
        <a-menu-item v-for="item in categories" :key="item.id">
            <span>
              <DropboxOutlined />
              {{item.name}}
            </span>
        </a-menu-item>
      </a-sub-menu>

      <a-menu-item key="review">
        <CheckSquareOutlined />
        <span>审核任务</span>
      </a-menu-item>

    </a-menu>
  </a-layout-sider>
</template>
<script lang="ts">
  import {
    ReadOutlined,
    LineChartOutlined,
    ApartmentOutlined,
    CheckSquareOutlined,
  } from '@ant-design/icons-vue';
  import { defineComponent, ref, onMounted } from 'vue';
  import axios from "axios";
  import {message} from "ant-design-vue";
  export default defineComponent({
    name: 'the-sider',
    setup () {
      const categories = ref();

      const handleQueryCategory = () => {
        axios.get("/category/list").then((response) => {
          const data = response.data;
          console.log(data)
          if (data.success) {
            categories.value = data.content;
            console.log(data.content);
          } else {
            message.error(data.message)
          }
        })
      }


      onMounted(()=>{
        handleQueryCategory();
      });

      return {
        categories
      }
    },
    components: {
      ReadOutlined,
      LineChartOutlined,
      ApartmentOutlined,
      CheckSquareOutlined,
    },
    data() {
      return {
        collapsed: ref<boolean>(false),
        selectedKeys: ref<string[]>(['1']),
      };
    },
  });
</script>
<style>
.logo {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: black;
  height:64px;
}
.logo img {
  width:64px;
  height:64px;
  margin: 10px;
}
</style>
