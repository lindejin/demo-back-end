const wfparams = {
    state: {
        params: '',

    },
    mutations: {

        SET_WF_PARAMS: (state, params) => {
            state.params = params
        }
    },
    actions: {
        setWfParams({commit}, params) {
            commit('SET_WF_PARAMS', params)
        }
    }
}

export default wfparams
