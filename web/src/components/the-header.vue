<template>
  <a-layout-header class="header" style="background: #ebebe7; padding: 0" >
    <a-row type="flex" justify="end">
      <a-col :span="3">
        <a-space>
          <a-button type="primary" shape="round" :size="large" @click="showLoginModal" v-show="!isLogin">
            <template #icon>
              <UserOutlined />
              登录
            </template>
          </a-button>
          <a-button type="primary" shape="round" :size="large" @click="showsigninModal" v-show="!isLogin">
            <template #icon>
              <UserOutlined />
              注册
            </template>
          </a-button>
          <a-button type="primary" shape="round" :size="large" @click="logout" v-show="isLogin">
            <template #icon>
              <UserOutlined />
              退出登录
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
    <a-modal
        title="注册"
        v-model:visible="signinModalVisible"
        :confirm-loading="signinModalLoading"
        @ok="signIn"
    >
      <a-form :model="newUser" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">

        <a-form-item label="登录名">
          <a-input v-model:value="newUser.name" />
        </a-form-item>

        <a-form-item label="密码">
          <a-input v-model:value="newUser.password" type="password" />
        </a-form-item>

        <a-form-item label="年龄">
          <a-input v-model:value="newUser.age" />
        </a-form-item>

        <a-form-item label="工号">
          <a-input v-model:value="newUser.employeeid" />
        </a-form-item>

        <a-form-item label="部门">
          <a-input v-model:value="newUser.department" />
        </a-form-item>

      </a-form>
    </a-modal>
  </a-layout-header>
</template>

<script lang="ts">
import { UserOutlined } from '@ant-design/icons-vue';
import {message} from "ant-design-vue";
import axios from "axios";
import store from "@/store";
import router from "@/router";
import { defineComponent, ref, computed } from 'vue';
declare let hexMd5: any;
declare let KEY: any;

export default defineComponent({
  name: 'the-header',
  setup () {
    const user = computed(()=>store.state.user);
    const loginUser = ref();
    const newUser = ref();
    const isLogin = ref(false);

    const loginModalVisible = ref(false);
    const loginModalLoading = ref(false);

    const signinModalVisible = ref(false);
    const signinModalLoading = ref(false);

    const showLoginModal = () => {
      loginModalVisible.value = true;
      loginUser.value = {
        loginName: "税管专家2",
        password: "asd123456"
      };
    };

    const showsigninModal = () => {
      signinModalVisible.value = true;
      newUser.value = {
        name: "",
        password: "",
        age: 0,
        employeeid : 0,
        department: "",
      };
    };

    /*校验是否全由8位数字组成 */
    function isPwdFormatValid(str: any) {
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
      loginUser.value.password = hexMd5(loginUser.value.password + KEY);
      axios.post('/user/login', loginUser.value).then((response) => {
        loginModalLoading.value = false;
        const data = response.data;
        if (data.success) {
          loginModalVisible.value = false;
          isLogin.value = true;
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
      axios.get('/user/logout/' + user.value.token).then((response) => {
        const data = response.data;
        if (data.success) {
          isLogin.value = false;
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

    const signIn = () => {
      console.log("注册");
      console.log(newUser.value)
      newUser.value.password = hexMd5(newUser.value.password + KEY);
      axios.post("/user/save", newUser.value).then((response) => {
        signinModalLoading.value = false;
        const data = response.data;
        if (data.success) {
          signinModalVisible.value = false;
          message.success("注册成功，请重新登陆");
        } else {
          message.error(data.message);
        }
      })
    }


    return {
      loginUser,
      loginModalVisible,
      loginModalLoading,
      showLoginModal,
      login,
      logout,
      user,
      isLogin,
      showsigninModal,
      signinModalVisible,
      signinModalLoading,
      signIn,
      newUser
    }
  },
  components: {
    UserOutlined,
  },
});
</script>