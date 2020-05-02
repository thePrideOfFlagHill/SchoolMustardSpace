export default [
  {
    path: 'itemPage',
    meta: { title: '' },
    name: 'commentPage',
    component: () => import('../components/manageComment/itemPage.vue')
  },
  {
    path: 'detail',
    meta: { title: '详细信息' },
    component: () => import('../components/manageComment/detail.vue')
  },
  {
    path: 'examine',
    meta: { title: '审核' },
    component: () => import('../components/manageTask/examine.vue')
  }
]
