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
      <el-menu-item index="2">
        <a href="https://www.ele.me" target="_blank">订单管理</a>
      </el-menu-item>
      <el-menu-item index="3" style="float:right;" disabled>消息中心</el-menu-item>
      <el-submenu index="4" style="float:right;">
        <template slot="title">用户</template>
        <el-menu-item index="4-1">选项1</el-menu-item>
        <el-menu-item index="4-2">选项2</el-menu-item>
        <el-menu-item index="4-3">选项3</el-menu-item>
        <el-submenu index="4-4">
          <template slot="title">选项4</template>
          <el-menu-item index="4-4-1">选项1</el-menu-item>
          <el-menu-item index="4-4-2">选项2</el-menu-item>
          <el-menu-item index="4-4-3">选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'Nav'
}
</script>

<style scoped>

</style>
