import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    option: {
      date: '',
      type: '',
      user: '',
      id: ''
    }
  },
  mutations: {
    setOption (state, set) {
    //  var temp = JSON.parse(JSON.stringify(set))// 深拷贝
      state.option = JSON.parse(JSON.stringify(set))
    }
  },
  actions: {
  },
  modules: {
  }
})
