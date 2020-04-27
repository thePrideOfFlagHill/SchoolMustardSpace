import Vue from 'vue'
import VueRouter from 'vue-router'

import overview from '../views/overview.vue'

import sonTask from './manageTask.js'
Vue.use(VueRouter)

const routes = [
  {
    path: '/overview',
    name: 'overview',
    component: overview
  },
  {
    path: '/manageTask',
    name: 'manageTask',
    component: () => import('../views/manageTask.vue'),
    children: sonTask
  }
]

const router = new VueRouter({
  routes
})

export default router
