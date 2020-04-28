import Vue from 'vue'
import VueRouter from 'vue-router'

import overview from '../views/overview.vue'

import sonTask from './manageTask.js'
Vue.use(VueRouter)

const routes = [
  {
    path: '/overview',
    name: 'overview',
    meta: { title: '概览' },
    component: overview
  },
  {
    path: '/manageTask',
    name: 'manageTask',
    redirect: '/manageTask/itemPage',
    meta: { title: '任务管理' },
    component: () => import('../views/manageTask.vue'),
    children: sonTask
  }
]

const router = new VueRouter({
  routes
})

export default router
