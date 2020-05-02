export default [
  {
    path: 'itemPage',
    meta: { title: '总览' },
    component: () => import('../components/manageAdmin/itemPage.vue')
  },
  {
    path: 'detail',
    meta: { title: '详细信息' },
    component: () => import('../components/manageAdmin/detail.vue')
  },
  {
    path: 'increase',
    meta: { title: '新增管理员' },
    component: () => import('../components/manageAdmin/increase.vue')
  },
  {
    path: 'change',
    meta: { title: '管理员信息修改' },
    component: () => import('../components/manageAdmin/change.vue')
  }
]
