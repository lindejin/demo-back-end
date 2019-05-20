
import service from '@/service'

const tagsView = {
  state: {
    username: '',
    userCode: '',
    teamCode: '',
    teamName: '',
    authorMenuList: '',
    authorButtonList: '',
    userList: [],
    teamList: [],
    userInfo: ''

  },
  getters: {

  },
  mutations: {
    SET_USERNAME: (state, username) => {
      state.username = username
    },
    SET_USER_CODE: (state, userCode) => {
      state.userCode = userCode
    },
    SET_TEAMCODE: (state, teamCode) => {
      state.teamCode = teamCode
    },
    SET_TEAMNAME: (state, teamName) => {
      state.teamName = teamName
    },
    SET_AUTHOR_BUTTON_LIST: (state, buttonList) => {
      state.authorButtonList = buttonList
    },
    SET_AUTHOR_MENU_LIST: (state, menuList) => {
      state.authorMenuList = menuList
    },
    SET_USER_LIST: (state, userList) => {
      state.userList = userList
    },
    SET_TEAM_LIST: (state, teamList) => {
      state.teamList = teamList
    },
    SET_USERINFO: (state, userInfo) => {
      state.userInfo = userInfo
    }
  },
  actions: {
    setUsername ({commit}, username) {
      commit('SET_USERNAME', username)
    },
    setUserCode ({commit}, userCode) {
      commit('SET_USER_CODE', userCode)
    },
    setTeamCode ({commit}, teamCode) {
      commit('SET_teamCode', teamCode)
    },
    setTeamName ({commit}, teamName) {
      commit('SET_teamName', teamName)
    },
    setAuthorButtonList ({commit}, buttonList) {
      commit('SET_AUTHOR_BUTTON_LIST', buttonList)
    },
    setAuthorMenuList ({commit}, menuList) {
      commit('SET_AUTHOR_MENU_LIST', menuList)
    },
    GetAllUserInfo ({ commit, state }) {
      return new Promise((resolve, reject) => {
        service.service.get('/system/userMgr/getAllUserInfo').then(res => {
          commit('SET_USER_LIST', res.data)
          resolve(res.data)
        })
      })
    },
    GetUserInfo ({ commit, state }) {
      return new Promise((resolve, reject) => {
        service.service.get('/user/initUser').then(res => {
          commit('SET_USERINFO', res.data)
          commit('SET_USERNAME', res.data.USERNAME)
          commit('SET_USER_CODE', res.data.USER_CODE)
          resolve(res.data)
        })
      })
    },
    GetTeamInfo ({ commit, state }) {
      return new Promise((resolve, reject) => {
        service.service.get('/user/getAllTeamInfo').then(res => {
          var teamList = []
          if (res.data) {
            teamList = Array.from(new Set(res.data.map((item) => {
              return JSON.stringify({'teamCode': item.TEAM_CODE, 'teamName': item.TEAM_NAME})
            }))).map((item) => {
              return JSON.parse(item)
            })
          } else {
            reject(teamList)
          }
          commit('SET_TEAM_LIST', teamList)
          var sTeamCode = localStorage.getItem('tern_teamCode')
          var currTeamInfo = teamList.find((item) => {
            return item.teamCode === sTeamCode
          })
          if (!currTeamInfo) {
            /* currTeamInfo = new Object() */
            /* ESLint 不推荐上面这样的定义方式 */
            currTeamInfo = {}
            currTeamInfo['teamCode'] = teamList[0].teamCode
            currTeamInfo['teamName'] = teamList[0].teamName
          }
          localStorage.setItem('tern_teamCode', currTeamInfo.teamCode)
          commit('SET_TEAMCODE', currTeamInfo.teamCode)
          commit('SET_TEAMNAME', currTeamInfo.teamName)
          resolve(teamList)
        })
      })
    },
    GetAuthorInfo ({ commit, state }) {
      return new Promise((resolve, reject) => {
        service.service.get('/user/getMenu?teamCode=' + state.teamCode).then(res => {
          commit('SET_AUTHOR_MENU_LIST', res.data)
          service.service.get('/system/menuMgr/getAuthorButtonList?teamCode=' + state.teamCode)
            .then(res => {
              commit('SET_AUTHOR_BUTTON_LIST', res.data)
              resolve(true)
            })
        })
      })
    }
  }
}
/* 为模块 tagsView 指定默认输出 */
export default tagsView
