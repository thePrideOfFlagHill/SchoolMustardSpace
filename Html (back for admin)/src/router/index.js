import Vue from 'vue'
import VueRouter from 'vue-router'

import overview from '../views/overview.vue'

import sonTask from './manageTask.js'
import sonLease from './manageLease.js'
import sonAdmin from './manageAdmin.js'

import taskComment from './taskComment.js'
import lostComment from './lostComment.js'
import leaseComment from './leaseComment.js'

import sonUser from './manageUser.js'
import sonLost from './manageLost.js'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
    // redirect: '/outer/overview'
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
        path: 'taskComment',
        name: 'taskComment',
        redirect: '/outer/taskComment/itemPage',
        meta: { title: '任务评论' },
        component: () => import('../views/Middle.vue'),
        children: taskComment
      },
      {
        path: 'lostComment',
        name: 'lostComment',
        redirect: '/outer/lostComment/itemPage',
        meta: { title: '失物评论' },
        component: () => import('../views/Middle.vue'),
        children: lostComment
      },
      {
        path: 'leaseComment',
        name: 'leaseComment',
        redirect: '/outer/leaseComment/itemPage',
        meta: { title: '租赁评论' },
        component: () => import('../views/Middle.vue'),
        children: leaseComment
      },
      {
        path: 'manageUser',
        name: 'manageUser',
        redirect: '/outer/manageUser/itemPage',
        meta: { title: '用户管理' },
        component: () => import('../views/Middle.vue'),
        children: sonUser
      },
      {
        path: 'manageLost',
        name: 'manageLost',
        redirect: '/outer/manageLost/itemPage',
        meta: { title: '失物管理' },
        component: () => import('../views/Middle.vue'),
        children: sonLost
      }
    ]
  }

]

const router = new VueRouter({
  routes
})

export default router
