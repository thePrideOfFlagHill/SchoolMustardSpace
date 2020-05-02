export default [
  {
    path: 'itemPage',
    meta: { title: '' },
    component: () => import('../components/manageUser/itemPage.vue')
  },
  {
    path: 'detail',
    meta: { title: '详细信息' },
    component: () => import('../components/manageUser/detail.vue')
  },
  {
    path: 'change',
    meta: { title: '用户信息修改' },
    component: () => import('../components/manageUser/change.vue')
  }
]
