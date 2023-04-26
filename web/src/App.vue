<template>
  <a-layout style="min-height: 100vh">
    <the-sider></the-sider>
    <a-layout>
      <the-header></the-header>
        <router-view/>
      <the-footer></the-footer>
    </a-layout>
  </a-layout>
</template>
<script lang="ts">
import { defineComponent} from 'vue';
import TheSider from "@/components/the-sider.vue";
import TheHeader from "@/components/the-header.vue";
import TheFooter from "@/components/the-footer.vue"
export default defineComponent({
  name: 'app',
  components: {
    TheSider,
    TheHeader,
    TheFooter
  }
});
</script>
