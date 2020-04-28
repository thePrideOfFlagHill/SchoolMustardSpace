export default [
  {
    path: 'itemPage',
    meta: { title: '总览' },
    component: () => import('../components/manageTask/table.vue')
  },
  {
    path: 'detail',
    meta: { title: '详细信息' },
    component: () => import('../components/manageTask/detail.vue')
  },
  {
    path: 'examine',
    meta: { title: '详细信息' },
    component: () => import('../components/manageTask/examine.vue')
  }
]
