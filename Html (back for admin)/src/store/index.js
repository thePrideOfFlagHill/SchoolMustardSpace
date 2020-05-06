import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    accountNumber: '',
    option: {
      date: '',
      type: '',
      user: '',
      id: '',
      content: '',
      contentType: ''
    },
    headPort: 'http://47.100.251.3/space' // 接口前缀

  },
  mutations: {
    setOption (state, set) {
    //  var temp = JSON.parse(JSON.stringify(set))// 深拷贝
      state.option = JSON.parse(JSON.stringify(set))
    },
    setAccountnumber (state, set) {
      state.accountNumber = JSON.parse(JSON.stringify(set))
    },
    setContenttype (state, set) {
      state.contentType = JSON.parse(JSON.stringify(set))
    }
  },
  actions: {
  },
  modules: {
  }
})
