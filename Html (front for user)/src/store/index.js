import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

import d2admin from './modules/d2admin'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    d2admin
  },
  state: {
    userid: '',
    user: ''
  },
  mutations: {
    setAccountnumber (state, set) {
      state.user = JSON.parse(JSON.stringify(set))
      axios.get(
        '/api/user/query/accountNumber/' + state.user
      ).then(function (res) {
        state.userid = res.data.data.id
      })
    }
  }
})
