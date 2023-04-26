<template>
  <a-layout-header class="header" style="background: #fff; padding: 0" >
    <a-row type="flex" justify="end">
      <a-col :span="2">
        <a-space>
          <a-button type="primary" shape="round" :size="large" @click="showLoginModal">
            <template #icon>
              <UserOutlined />
              登录
            </template>
          </a-button>
        </a-space>
      </a-col>
    </a-row>

    <a-modal
        title="登录"
        v-model:visible="loginModalVisible"
        :confirm-loading="loginModalLoading"
        @ok="login"
    >
      <a-form :model="loginUser" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">

        <a-form-item label="登录名">
          <a-input v-model:value="loginUser.loginName" />
        </a-form-item>

        <a-form-item label="密码">
          <a-input v-model:value="loginUser.password" type="password" />
        </a-form-item>

      </a-form>
    </a-modal>
  </a-layout-header>
</template>
<script>
import { UserOutlined } from '@ant-design/icons-vue';
import {message} from "ant-design-vue";
import axios from "axios";
import store from "@/store";
import router from "@/router";
import { defineComponent, ref, computed } from 'vue';
export default defineComponent({
  name: 'the-header',
  setup () {
    const user = computed(()=>store.state.user);
    const loginUser = ref();

    const loginModalVisible = ref(false);
    const loginModalLoading = ref(false);

    const showLoginModal = () => {
      loginModalVisible.value = true;
      loginUser.value = {
        loginName: "test",
        password: "test123"
      };
    };

    /*校验是否全由8位数字组成 */
    function isPwdFormatValid(str) {
      let reg=/^(?![0-9]+$)[0-9A-Za-z]{6,32}$/;  /*定义验证表达式*/
      return reg.test(str);   /*进行验证*/
    }

    const login = () => {
      loginModalLoading.value = true;
      if (!isPwdFormatValid(loginUser.value.password)) {
        loginModalLoading.value = false;
        message.error("[密码]应包含英文和数组，长度6-20位");
        return;
      }
      axios.post('/user/login', loginUser.value).then((response) => {
        loginModalLoading.value = false;
        const data = response.data;
        if (data.success) {
          loginModalVisible.value = false;
          message.success("登陆成功");
          // 设置全局变量
          store.commit("setUser", data.content);
          console.log("登陆成功，返回：", data.content);
          console.log("登陆后store：", store.state.user);
        } else {
          message.error(data.message);
        }
      })

    }

    const logout = () => {
      console.log("退出登陆");
      axios.get('/redis/logout/' + user.value.token).then((response) => {
        const data = response.data;
        if (data.success) {
          message.success("退出登陆成功！");
          // 设置全局变量
          store.commit("setUser", {});
          // 退出登录时返回首页
          router.push('/');
        } else {
          message.error(data.message);
        }
      });
    };


    return {
      loginUser,
      loginModalVisible,
      loginModalLoading,
      showLoginModal,
      login,
      logout,
      user
    }
  },
  components: {
    UserOutlined,
  },
});
</script>