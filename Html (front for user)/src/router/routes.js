import layoutHeaderAside from '@/layout/header-aside'

// 由于懒加载页面太多的话会造成webpack热更新太慢，所以开发环境不使用懒加载，只有生产环境使用懒加载
const _import = require('@/libs/util.import.' + process.env.NODE_ENV)

/**
 * 在主框架内显示
 */
const frameIn = [
  {
    path: '/',
    redirect: { name: 'login' },
    component: layoutHeaderAside,
    children: [
      // 首页
      {
        path: 'index',
        name: 'index',
        meta: {
          auth: true
        },
        component: _import('system/index')
      },
      {
        path: 'page1',
        name: 'page1',
        meta: {
          title: '搜索任务',
          auth: true
        },
        component: _import('work/workList.vue')
      },
      {
        path: 'page2',
        name: 'page2',
        meta: {
          title: '发布任务',
          auth: true
        },
        component: _import('work/insertWork')
      },
      {
        path: 'page3',
        name: 'page3',
        meta: {
          title: '我的任务',
          auth: true
        },
        component: _import('work/myWork')
      },
      {
        path: 'page4',
        name: 'page4',
        meta: {
          title: '任务详情',
          auth: true
        },
        component: _import('work/workDetail')
      },
      {
        path: 'page5',
        name: 'page5',
        meta: {
          title: '搜索物品',
          auth: true
        },
        component: _import('lostFound/workList.vue')
      },
      {
        path: 'page6',
        name: 'page6',
        meta: {
          title: '发布召领',
          auth: true
        },
        component: _import('lostFound/insertWork')
      },
      {
        path: 'page7',
        name: 'page7',
        meta: {
          title: '我的发布',
          auth: true
        },
        component: _import('lostFound/myWork')
      },
      {
        path: 'page8',
        name: 'page8',
        meta: {
          title: '物品详情',
          auth: true
        },
        component: _import('lostFound/workDetail')
      },
      {
        path: 'page9',
        name: 'page9',
        meta: {
          title: '搜索物品',
          auth: true
        },
        component: _import('rental/workList.vue')
      },
      {
        path: 'page10',
        name: 'page10',
        meta: {
          title: '发布租凭',
          auth: true
        },
        component: _import('rental/insertWork')
      },
      {
        path: 'page11',
        name: 'page11',
        meta: {
          title: '我的发布',
          auth: true
        },
        component: _import('rental/myWork')
      },
      {
        path: 'page12',
        name: 'page12',
        meta: {
          title: '物品详情',
          auth: true
        },
        component: _import('rental/workDetail')
      },
      // 系统 前端日志
      {
        path: 'log',
        name: 'log',
        meta: {
          title: '前端日志',
          auth: true
        },
        component: _import('system/log')
      },
      // 刷新页面 必须保留
      {
        path: 'refresh',
        name: 'refresh',
        hidden: true,
        component: _import('system/function/refresh')
      },
      // 页面重定向 必须保留
      {
        path: 'redirect/:route*',
        name: 'redirect',
        hidden: true,
        component: _import('system/function/redirect')
      }
    ]
  }
]

/**
 * 在主框架之外显示
 */
const frameOut = [
  // 登录
  {
    path: '/login',
    name: 'login',
    component: _import('system/login')
  }
]

/**
 * 错误页面
 */
const errorPage = [
  {
    path: '*',
    name: '404',
    component: _import('system/error/404')
  }
]

// 导出需要显示菜单的
export const frameInRoutes = frameIn

// 重新组织后导出
export default [
  ...frameIn,
  ...frameOut,
  ...errorPage
]
