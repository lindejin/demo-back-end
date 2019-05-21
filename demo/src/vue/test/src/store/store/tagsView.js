/* import Vue from 'vue' */
const tagsView = {
  state: {
    visitedViews: [],
    cachedViews: [],
    visitedViewsMap: {},
    currentTopView: 'home'
  },
  mutations: {
    ADD_VISITED_VIEWS_MAP: (state, view) => {
      if (!state.visitedViewsMap[view.meta.topParentId]) {
        state.visitedViewsMap[view.meta.topParentId] =
                    {
                      currView: view,
                      views: [{
                        name: view.name,
                        path: view.path,
                        title: view.query.title || view.meta.title || 'no-name',
                        componentName: view.meta.componentName || 'no-name'
                      }]
                    }
      } else {
        let visitedView = state.visitedViewsMap[view.meta.topParentId]
        visitedView.currView = view
        if (!visitedView.views.some(v => v.path === view.path)) {
          visitedView.views.push({
            name: view.name,
            path: view.path,
            title: view.query.title || view.meta.title || 'no-name',
            componentName: view.meta.componentName || 'no-name'
          })
        }
        state.visitedViewsMap[view.meta.topParentId] = visitedView
        state.visitedViewsMap = { ...state.visitedViewsMap }
      }
    },
    DEL_VISITED_VIEWS_MAP: (state, view) => {
      let visitedView = state.visitedViewsMap[view.meta.topParentId]
      if (!visitedView || visitedView.views.length < 1) return
      for (const [i, v] of visitedView.views.entries()) {
        if (v.path === view.path) {
          visitedView.views.splice(i, 1)
          break
        }
      }
      state.visitedViewsMap[view.meta.topParentId] = visitedView
      state.visitedViewsMap = { ...state.visitedViewsMap }
    },
    DEL_OTHERS_VIEWS_MAP: (state, view) => {
      let visitedView = state.visitedViewsMap[view.meta.topParentId]
      for (const [i, v] of visitedView.views.entries()) {
        if (v.path === view.path) {
          visitedView.views = visitedView.views.slice(i, i + 1)
          break
        }
      }
      state.visitedViewsMap[view.meta.topParentId] = visitedView
      state.visitedViewsMap = { ...state.visitedViewsMap }
    },
    DEL_ALL_VIEWS_MAP: (state, view) => {
      // delete state.visitedViewsMap[view.meta.topParentId];
      state.visitedViewsMap = {}
      // state.visitedViewsMap = { ...state.visitedViewsMap }
    },
    ADD_VISITED_VIEWS: (state, view) => {
      if (state.visitedViews.some(v => v.path === view.path)) return
      state.visitedViews.push({
        name: view.name,
        path: view.path,
        title: view.meta.title || 'no-name',
        componentName: view.meta.componentName || 'no-name'
      })
      if (!view.meta.noCache) {
        state.cachedViews.push(view.name)
      }
    },
    DEL_VISITED_VIEWS: (state, view) => {
      for (const [i, v] of state.visitedViews.entries()) {
        if (v.path === view.path) {
          state.visitedViews.splice(i, 1)
          break
        }
      }
      for (const i of state.cachedViews) {
        if (i === view.name) {
          const index = state.cachedViews.indexOf(i)
          state.cachedViews.splice(index, 1)
          break
        }
      }
    },
    DEL_OTHERS_VIEWS: (state, view) => {
      for (const [i, v] of state.visitedViews.entries()) {
        if (v.path === view.path) {
          state.visitedViews = state.visitedViews.slice(i, i + 1)
          break
        }
      }
      for (const i of state.cachedViews) {
        if (i === view.name) {
          const index = state.cachedViews.indexOf(i)
          state.cachedViews = state.cachedViews.slice(index, i + 1)
          break
        }
      }
    },
    DEL_ALL_VIEWS: (state) => {
      state.visitedViews = []
      state.cachedViews = []
    },
    SET_CURR_TOP_VIEW: (state, currentTopView) => {
      state.currentTopView = currentTopView
    }
  },
  actions: {
    addVisitedViewsMap ({ commit }, view) {
      commit('ADD_VISITED_VIEWS_MAP', view)
    },
    delVisitedViewsMap ({ commit, state }, view, topParentId) {
      return new Promise((resolve) => {
        commit('DEL_VISITED_VIEWS_MAP', view)
        resolve({...state.visitedViewsMap[view.meta.topParentId]})
      })
    },
    delOthersViewsMap ({ commit, state }, view) {
      return new Promise((resolve) => {
        commit('DEL_OTHERS_VIEWS_MAP', view)
        resolve({...state.visitedViewsMap[view.meta.topParentId]})
      })
    },
    delAllViewsMap ({ commit, state }, view) {
      return new Promise((resolve) => {
        commit('DEL_ALL_VIEWS_MAP', view)
        resolve([...state.visitedViewsMap])
      })
    },
    // ==============================
    addVisitedViews ({ commit }, view) {
      commit('ADD_VISITED_VIEWS', view)
    },
    delVisitedViews ({ commit, state }, view) {
      return new Promise((resolve) => {
        commit('DEL_VISITED_VIEWS', view)
        resolve([...state.visitedViews])
      })
    },
    delOthersViews ({ commit, state }, view) {
      return new Promise((resolve) => {
        commit('DEL_OTHERS_VIEWS', view)
        resolve([...state.visitedViews])
      })
    },
    delAllViews ({ commit, state }) {
      return new Promise((resolve) => {
        commit('DEL_ALL_VIEWS')
        resolve([...state.visitedViews])
      })
    }
  }
}

export default tagsView
