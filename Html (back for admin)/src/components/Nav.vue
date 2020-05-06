<template>
  <div>
    <el-menu
      class="Nav"
      mode="horizontal"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="1">处理中心</el-menu-item>
      <el-submenu index="2" style="float:right;">
        <template slot="title">{{this.$store.state.accountNumber}}</template>
        <el-menu-item index="2-1" @click="loginOut()">退出</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'Nav',
  methods: {
    loginOut () {
      this.$store.commit('setAccountnumber', null)
      if (this.$store.state.accountNumber == null) {
        this.$router.push({
          name: 'login'
        })
      }
    }
  }
}
</script>

<style scoped>
</style>
