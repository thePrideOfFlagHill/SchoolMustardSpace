import Vue from 'vue'
import VueRouter from 'vue-router'

import overview from '../views/overview.vue'

import sonTask from './manageTask.js'
import sonLease from './manageLease.js'
import sonAdmin from './manageAdmin.js'
import sonComment from './manageComment.js'
import sonUser from './manageUser.js'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/outer'
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login.vue')
  },
  {
    path: '/outer',
    name: 'outer',
    component: () => import('../views/Outer.vue'),
    children: [
      {
        path: 'overview',
        name: 'overview',
        meta: { title: '概览' },
        component: overview
      },
      {
        path: 'manageTask',
        name: 'manageTask',
        redirect: '/outer/manageTask/itemPage',
        meta: { title: '任务管理' },
        component: () => import('../views/Middle.vue'),
        children: sonTask
      },
      {
        path: 'manageLease',
        name: 'manageLease',
        redirect: '/outer/manageLease/itemPage',
        meta: { title: '租赁管理' },
        component: () => import('../views/Middle.vue'),
        children: sonLease
      },
      {
        path: 'manageAdmin',
        name: 'manageAdmin',
        redirect: '/outer/manageAdmin/itemPage',
        meta: { title: '管理员' },
        component: () => import('../views/Middle.vue'),
        children: sonAdmin
      },
      {
        path: 'manageComment',
        name: 'manageComment',
        redirect: '/outer/manageComment/itemPage',
        meta: { title: '评论管理' },
        component: () => import('../views/Middle.vue'),
        children: sonComment
      },
      {
        path: 'manageUser',
        name: 'manageUser',
        redirect: '/outer/manageUser/itemPage',
        meta: { title: '用户管理' },
        component: () => import('../views/Middle.vue'),
        children: sonUser
      }
    ]
  }

]

const router = new VueRouter({
  routes
})

export default router
