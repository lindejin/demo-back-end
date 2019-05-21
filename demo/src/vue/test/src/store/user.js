
const tagsView = {
  state: {
    authorButtonList: ''
  },
  getters: {
  },
  mutations: {
    SET_AUTHOR_BUTTON_LIST: (state, buttonList) => {
      state.authorButtonList = buttonList
    }
  },
  actions: {
    setAuthorButtonList ({commit}, buttonList) {
      commit('SET_AUTHOR_BUTTON_LIST', buttonList)
    }
  }
}
/* 为模块 tagsView 指定默认输出 */
export default tagsView
