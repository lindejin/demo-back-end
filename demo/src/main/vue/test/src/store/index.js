import Vue from 'vue'
import Vuex from 'vuex'

import user from './user'

Vue.use(Vuex)
/* */
const store = new Vuex.Store({
  modules: {
    user
  },
  getters: {
    user: state => state.user
  },
  mutations: {
    // 修改token，并将token存入localStorage
    setToken (state, token) {
      state.token = token
      localStorage.setItem('token', token.token)
    },
    delToken (state) {
      state.token = ''
      localStorage.removeItem('token')
    }
  },
  actions: {
  },
  state: {
    user: {},
    // 存储token
    token: localStorage.getItem('token') ? localStorage.getItem('token') : ''
  }
})
export default store
