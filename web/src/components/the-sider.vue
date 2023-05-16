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
            <router-link :to="{path: '/knowledge-manage', query: {name: item.name}}">
              <span>
                <DropboxOutlined />
                {{item.name}}
              </span>
            </router-link>
          </a-menu-item>

      </a-sub-menu>


      <a-menu-item key="statistic">
        <router-link to="/statistic">
          <LineChartOutlined />
          <span>查看统计数据</span>
        </router-link>
      </a-menu-item>

      <a-menu-item key="class_manage">
        <router-link to="/class-manage">
          <ApartmentOutlined />
          <span>风险类别管理</span>
        </router-link>
      </a-menu-item>

<!--      <a-sub-menu key="class_manage">-->
<!--        <template #title>-->
<!--              <span>-->
<!--                <ApartmentOutlined />-->
<!--                <span>风险类别管理</span>-->
<!--              </span>-->
<!--        </template>-->
<!--        <a-menu-item v-for="item in cateManage" :key="item.name">-->
<!--            <span>-->
<!--              <DropboxOutlined />-->
<!--              {{item.name}}-->
<!--            </span>-->
<!--        </a-menu-item>-->
<!--      </a-sub-menu>-->

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
  import {Tool} from "@/util/tool";
  import {message} from "ant-design-vue";
  export default defineComponent({
    name: 'the-sider',
    setup () {
      const categories = ref();

      const handleQueryCategory = (params: any) => {
        axios.get("/category/list", {
          params: {
            page: params.page,
            size: params.size
          }
        }).then((response) => {
          const data = response.data;
          console.log(data)
          if (data.success) {
            categories.value = data.content.list;
            console.log(data.content);
          } else {
            message.error(data.message)
          }
        })
      }

      onMounted(()=>{
        handleQueryCategory({
          page: 0,
          size: 20
        })
      });

      return {
        categories,
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
