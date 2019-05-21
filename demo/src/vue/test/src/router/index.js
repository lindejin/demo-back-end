import Vue from 'vue'
import Router from 'vue-router'
import Table from '@/components/test/tree'
import User from '@/components/test/page/user/userlist'
import Admin from '@/components/test/page/adminlist'
import serach from '@/view/shopping/search'
import introduction from '@/view/shopping/introduction'
import home02 from '@/view/home2'
import NProgress from 'nprogress'
import 'babel-polyfill'

Vue.use(Router)

let routes = [
  {
    path: '',
    component: Table,
    redirect: '/home',
    children: [
      {
        path: 'home',
        component: () => import('@/components/test/page/home'),
        name: '首页',
        meta: { title: '首页', noCache: true, affix: true, islogin02: true }
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/view/login'),
    name: '登录页',
    meta: { title: '登录页', islogin: false }
  },
  {
    path: '/home1',
    component: () => import('@/view/home'),
    name: 'home1',
    meta: { title: 'home1', islogin: false },
    children: [
      // 首页
      {
        path: '',
        component: home02,
        name: 'home02',
        meta: { title: 'home02', islogin: false }
      },
      // 水果搜索页面
      {
        path: '/search',
        component: serach,
        name: 'search',
        meta: {title: 'search', islogin: false}
      },
      // 水果详情页面
      {
        path: '/introduction',
        component: introduction,
        name: 'introduction',
        meta: { title: 'introduction', islogin: false }
      },
      // 购物车结算页面
      {
        path: '/shopcart',
        component: () => import('@/view/shopping/shopcart'),
        name: 'shopcart',
        meta: { title: 'shopcart', islogin: true }
      },
      // 用户个人中心
      {
        path: '/index',
        component: () => import('@/view/person/index'),
        meta: {title: 'index'},
        children: [
          {
            path: '/',
            name: 'MyOrder',
            component: () => import('@/view/person/MyOrder'),
            meta: { title: 'MyOrder', islogin: true }
          },
          {
            path: 'myAddress',
            name: 'MyAddress',
            component: () => import('@/view/person/MyAddress'),
            meta: { title: 'MyAddress', islogin: true }
          },
          {
            path: 'addAddress',
            name: 'AddAddress',
            component: () => import('@/view/person/AddAddress'),
            meta: { title: 'AddAddress', islogin: true }
          },
          {
            path: 'myOrder',
            name: 'MyOrder02',
            component: () => import('@/view/person/MyOrder'),
            meta: { title: 'MyOrder02', islogin: true }
          },
          {
            path: 'myShoppingCart',
            name: 'MyShoppingCart',
            component: () => import('@/view/person/MyShoppingCart'),
            meta: { title: 'myShoppingCart', islogin: true }
          }]
      }
    ]
  },
  // 注册页面
  {
    path: '/register',
    component: () => import('@/view/shopping/register'),
    name: 'register',
    meta: { title: 'register', islogin: false }
  },
  {
    path: '/login02',
    component: () => import('@/components/test/page/login02'),
    name: 'login02',
    meta: { title: 'login02', islogin02: false }
  },
  {
    path: '/',
    name: 'tree',
    component: Table,
    redirect: '/user',
    children: [
      {
        path: '/user',
        name: 'user',
        meta: {title: '用户管理', islogin02: true},
        component: User
      },
      {
        path: '/admin',
        name: 'admin',
        meta: { title: '管理员管理', islogin02: true },
        component: Admin
      },
      {
        path: '/fruit',
        name: 'fruit',
        meta: { title: '水果管理', islogin02: true },
        component: () => import('@/components/test/page/fruit/index')
      },
      {
        path: '/order',
        name: 'order',
        meta: { title: '订单管理', islogin02: true },
        component: () => import('@/components/test/page/order/index')
      },
      {
        path: '/one',
        component: () => import('@/components/testuser/one'),
        name: 'one',
        meta: { title: '测试', islogin02: true }
      },
      {
        path: '/unlogin',
        component: () => import('@/components/test/unlogin'),
        name: 'unlogin',
        meta: { title: 'unlogin', islogin02: true }
      }
    ]
  },
  {
    path: '/user1',
    name: 'user1',
    meta: { title: '用户管理', islogin02: true },
    component: User
  }
]
var router = new Router({
  routes: routes
})
router.beforeEach((to, from, next) => {
  NProgress.start()
  if (to.matched.some(record => record.meta.islogin)) { // 判断该路由是否需要登录权限
    let login01 = localStorage.getItem('Flag01')
    console.log(login01)
    if (login01 && login01 != null) { // 判断当前的token是否存在
      next()
    } else {
      next({
        path: '/login',
        query: {redirect: to.fullPath} // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
  } else if (to.matched.some(record => record.meta.islogin02)) {
    let login02 = localStorage.getItem('Flag02')
    console.log(login02)
    if (login02 && login02 != null) { // 判断当前的token是否存在
      next()
    } else {
      next({
        path: '/login02',
        query: {redirect: to.fullPath} // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
  } else {
    next()
  }
  next()
})
router.afterEach((to) => {
  NProgress.done()
})
export default router
