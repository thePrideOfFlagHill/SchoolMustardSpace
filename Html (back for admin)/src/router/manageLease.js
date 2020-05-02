export default [
  {
    path: 'itemPage',
    component: () => import('../components/manageLease/itemPage.vue')
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
