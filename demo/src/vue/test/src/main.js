// 全局配置中心
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from './axios/axios'

import TernTable from './components/el/tern-table.vue'
import TernButton from './components/el/tern-button.vue'
import TernForm from './components/el/tern-form.vue'

import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

import iView from 'iview'
import 'iview/dist/styles/iview.css'

import store from './store'
import fontawesome from '@fortawesome/fontawesome'
// import FontAwesomeIcon from '@fortawesome/vue-fontawesome'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
import solid from '@fortawesome/fontawesome-free-solid'
import regular from '@fortawesome/fontawesome-free-regular'
import brands from '@fortawesome/fontawesome-free-brands'

import 'font-awesome/css/font-awesome.css'
// import './node_modules/bootstrap/dist/css/bootstrap.min.css'
// import './node_modules/bootstrap/dist/js/bootstrap.min.js'

/* 设置axios请求接口 访问的地址前缀 */
// axios.defaults.baseURL = 'http://localhost:8088'
/* 设置可接收cookie，session */
// axios.defaults.withCredentials = true
// axios.defaults.headers = {
//   'token': 'e XAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NTY1MDE2MDI3NjMsInBheWxvYWQiOiJ7XCJ1c2VySWRcIjpudWxsLFwidXNlck5hbWVcIjpcInNzc1wiLFwidXNlclBhc3NcIjpcIjEyM1wiLFwidXNlckVtYWlsXCI6bnVsbCxcInVzZXJQaG9uZVwiOm51bGwsXCJ1c2VyUXVlc3Rpb25cIjpudWxsLFwidXNlckFuc3dlclwiOm51bGwsXCJ1c2VyU3RhdGVcIjpudWxsLFwidXNlclJvbGVcIjpudWxsLFwiY3JlYXRlVGltZVwiOm51bGwsXCJ1cGRhdGVUaW1lXCI6bnVsbH0ifQ.QSnVUwezyff74YS2CqH5gy_wDFw6qj6S_HEzm3IFKC8',
//   'Content-Type': 'application/json;charset=utf-8'
// }
// axios.defaults.headers.common['token'] = '111111111111'
Vue.use(ElementUI)
Vue.use(axios)
Vue.component('tern-table', TernTable)
Vue.component('tern-button', TernButton)
Vue.component('tern-form', TernForm)

Vue.use(iView)

Vue.config.productionTip = false

fontawesome.library.add(solid)
fontawesome.library.add(regular)
fontawesome.library.add(brands)

Vue.component('font-awesome-icon', FontAwesomeIcon)
/* 进度条 */
NProgress.inc(0.2)
NProgress.configure({ easing: 'ease', speed: 500, showSpinner: false })
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
