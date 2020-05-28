import util from '@/libs/util.js'

export default {
  namespaced: true,
  mutations: {
    /**
     * @description 
     * @param {Object} state state
     */
    versionShow () {
      util.log.capsule('D2Admin', `v${process.env.VUE_APP_VERSION}`)
      
    }
  }
}
