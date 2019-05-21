import Vue from 'vue'
import Vuex from 'vuex'

import tagsView from './tagsView'
import user from './user'
import wfParams from './wfparams'

import service from '@/service'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    tagsView,
    user,
    wfParams

  },
  getters: {
    visitedViews: state => state.tagsView.visitedViews,
    cachedViews: state => state.tagsView.cachedViews,
    user: state => state.user,
    wfParams: state => state.wfParams.params,
    dimList: state => state.dimList,
    scheDimList: state => state.scheDimList,
    scheDimMap: state => state.scheDimMap,
    getUserCnName: (state) => (username) => {
      var user = state.user.userList.find((user) => {
        return user.USERNAME === username
      })
      if (!user || !user.USER_CN_NAME) {
        return ''
      }
      return user.USER_CN_NAME
    }
  },
  mutations: {
    SET_DIMLIST: (state, dimList) => {
      state.dimList = dimList
    },
    SET_SCHEDIMLIST: (state, scheDimList) => {
      state.scheDimList = scheDimList
    },
    SET_SCHEDIMMAP: (state, scheDimMap) => {
      state.scheDimMap = scheDimMap
    }
  },
  actions: {
    GetDimList ({ commit, state }) {
      return new Promise((resolve, reject) => {
        service.service.get('/system/com/getDim').then(res => {
          commit('SET_DIMLIST', res.data)
        })
      })
    },
    setDimList ({commit}, dimList) {
      commit('SET_DIMLIST', dimList)
    },
    setScheDimList ({commit}, scheDimList) {
      commit('SET_SCHEDIMLIST', scheDimList)
    },
    setScheDimMap ({commit}, scheDimMap) {
      commit('SET_SCHEDIMMAP', scheDimMap)
    }
  },
  state: {
    user: {},
    username: '',
    dimList: [],
    scheDimList: [],
    scheDimMap: {}
  }

})

export default store
