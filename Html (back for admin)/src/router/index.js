import Vue from 'vue'
import VueRouter from 'vue-router'

import overview from '../views/overview.vue'

import sonTask from './manageTask.js'
import sonLease from './manageLease.js'
import sonAdmin from './manageAdmin.js'
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
    component: () => import('../views/Middle.vue'),
    children: sonTask
  },
  {
    path: '/manageLease',
    name: 'manageLease',
    redirect: '/manageLease/itemPage',
    meta: { title: '租赁管理' },
    component: () => import('../views/Middle.vue'),
    children: sonLease
  },
  {
    path: '/manageAdmin',
    name: 'manageAdmin',
    redirect: '/manageAdmin/itemPage',
    meta: { title: '管理员' },
    component: () => import('../views/Middle.vue'),
    children: sonAdmin
  }

]

const router = new VueRouter({
  routes
})

export default router
