export default [
  {
    path: 'itemPage',
    meta: { title: '总览' },
    component: () => import('../components/manageLease/table.vue')
  },
  {
    path: 'detail',
    meta: { title: '详细信息' },
    component: () => import('../components/manageLease/detail.vue')
  },
  {
    path: 'examine',
    meta: { title: '审核' },
    component: () => import('../components/manageLease/examine.vue')
  }
]
