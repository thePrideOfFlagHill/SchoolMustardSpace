export default [
  {
    path: 'itemPage',
    meta: { title: '' },
    name: 'commentPage',
    component: () => import('../components/taskComment/itemPage.vue')
  },
  {
    path: 'detail',
    meta: { title: '详细信息' },
    component: () => import('../components/taskComment/detail.vue')
  }
]
