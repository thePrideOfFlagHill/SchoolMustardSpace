import { uniqueId } from 'lodash'

/**
 * @description 给菜单数据补充上 path 字段
 * @param {Array} menu 原始的菜单数据
 */
function supplementPath (menu) {
  return menu.map(e => ({
    ...e,
    path: e.path || uniqueId('d2-menu-empty-'),
    ...e.children ? {
      children: supplementPath(e.children)
    } : {}
  }))
}

export const menuHeader = supplementPath([
  { path: '/index', title: '首页', icon: 'home' },
  {
    title: '发布任务',
    icon: 'folder-o',
    children: [
      { path: '/page1', title: '搜索任务' },
      { path: '/page2', title: '发布任务' },
      { path: '/page3', title: '我的任务' }
      // { path: '/page4', title: '任务详情' }
    ]
  },
  {
    title: '失物招领',
    icon: 'folder-o',
    children: [
      { path: '/page5', title: '搜索物品' },
      { path: '/page6', title: '发布物品' },
      { path: '/page7', title: '我的物品' }
      // { path: '/page4', title: '任务详情' }
    ]
  },
  {
    title: '物品租凭',
    icon: 'folder-o',
    children: [
      { path: '/page9', title: '搜索租凭' },
      { path: '/page10', title: '发布租凭' },
      { path: '/page11', title: '我的租凭' }
      // { path: '/page4', title: '任务详情' }
    ]
  }

])

export const menuAside = supplementPath([
  { path: '/index', title: '首页', icon: 'home' },
  {
    title: '发布任务',
    icon: 'folder-o',
    children: [
      { path: '/page1', title: '搜索任务' },
      { path: '/page2', title: '发布任务' },
      { path: '/page3', title: '我的任务' }
      // { path: '/page4', title: '任务详情' }
    ]
  },
  {
    title: '失物招领',
    icon: 'folder-o',
    children: [
      { path: '/page5', title: '搜索物品' },
      { path: '/page6', title: '发布物品' },
      { path: '/page7', title: '我的物品' }
      // { path: '/page4', title: '任务详情' }
    ]
  },
  {
    title: '物品租凭',
    icon: 'folder-o',
    children: [
      { path: '/page9', title: '搜索物品' },
      { path: '/page10', title: '发布租凭' },
      { path: '/page11', title: '我的租凭' }
      // { path: '/page4', title: '任务详情' }
    ]
  },
  {
    title: '个人空间',
    icon: 'folder-o',
    children: [
      { path: '/page13', title: '个人信息' },
      { path: '/page14', title: '个人信息修改' }
    ]
  }
])
