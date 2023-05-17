import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'
import ClassManager from '../views/ClassManage.vue'
import KnowledgeManage from '../views/KnowledgeManage.vue'
import Statistic from "../views/Statistic.vue";
import Review from '../views/Review.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/class-manage',
    name: 'ClassManager',
    component: ClassManager
  },
  {
    path: '/knowledge-manage',
    name: 'KnowledgeManage',
    component: KnowledgeManage
  },
  {
    path: '/statistic',
    name: 'Statistic',
    component: Statistic
  },
  {
    path: '/review',
    name: 'Review',
    component: Review
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
