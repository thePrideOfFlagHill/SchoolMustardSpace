import Vue from 'vue'
import VueRouter from 'vue-router'
import overview from '../views/overview.vue'

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
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/manageTask.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
