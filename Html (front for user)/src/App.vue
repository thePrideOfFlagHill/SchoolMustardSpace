<template>
  <div id="app">
    <router-view v-if="isRouterActive" />
  </div>
</template>

<script>
import util from '@/libs/util'
export default {
  name: 'app',
  provide(){
    return{
      reload:this.reload
    }
  },
  data(){
    return{
    isRouterActive:true
    }
  }
  ,
  watch: {
    '$i18n.locale': 'i18nHandle'
  },
  created () {
    this.i18nHandle(this.$i18n.locale)
  },
  methods: {
    i18nHandle (val, oldVal) {
      util.cookies.set('lang', val)
      document.querySelector('html').setAttribute('lang', val)
    },
    reload(){
        this.isRouterActive=false
        this.$nextTick(function(){
          this.isRouterActive=true
        })
    }
  },
}
</script>

<style lang="scss">
@import "~@/assets/style/public-class.scss";
</style>
