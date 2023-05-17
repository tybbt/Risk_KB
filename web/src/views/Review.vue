<template>
  <a-layout>
    <a-layout-content :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">

    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from 'vue';
import axios from "axios";
import {Tool} from "@/util/tool";
import {message} from "ant-design-vue";

export default defineComponent({
  name: 'Review',
  setup() {
    const columns = [
      {
        title: 'Action',
        key: 'action',
        slots: { customRender: 'action' }
      }
    ]


    onMounted(()=>{

    })

    return {
      columns
    }
  }
});
</script>
