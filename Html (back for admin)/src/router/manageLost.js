export default [
  {
    path: 'itemPage',
    meta: { title: '' },
    component: () => import('../components/manageLost/itemPage.vue')
  },
  {
    path: 'detail',
    meta: { title: '详细信息' },
    component: () => import('../components/manageLost/detail.vue')
  },
  {
    path: 'examine',
    meta: { title: '审核' },
    component: () => import('../components/manageLost/examine.vue')
  }
]
