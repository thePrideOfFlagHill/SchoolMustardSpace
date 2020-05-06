<template>
  <div>
    <el-menu
      :default-active="this.$route.path"
      class="el-menu-vertical-demo"
      background-color="#fff"
      text-color="#545c64"
      active-text-color="#ffd04b"
      router
    >
      <el-menu-item index="/outer/overView">
        <i class="el-icon-document"></i>
        <span slot="title">概览</span>
      </el-menu-item>
      <el-menu-item index="/outer/manageTask/itemPage">
        <i class="el-icon-document"></i>
        <span slot="title">任务管理</span>
      </el-menu-item>
      <el-menu-item index="/outer/manageLease/itemPage">
        <i class="el-icon-document"></i>
        <span slot="title">租赁管理</span>
      </el-menu-item>
      <el-menu-item index="/outer/manageLost/itemPage">
        <i class="el-icon-document"></i>
        <span slot="title">失物管理</span>
      </el-menu-item>
      <el-menu-item index="/outer/manageUser/itemPage">
        <i class="el-icon-document"></i>
        <span slot="title">用户列表</span>
      </el-menu-item>
      <el-menu-item index="/outer/taskComment/itemPage">
        <i class="el-icon-document"></i>
        <span slot="title">任务评论</span>
      </el-menu-item>
       <el-menu-item index="/outer/leaseComment/itemPage">
        <i class="el-icon-document"></i>
        <span slot="title">租赁评论</span>
      </el-menu-item>
      <el-menu-item index="/outer/lostComment/itemPage">
        <i class="el-icon-document"></i>
        <span slot="title">失物评论</span>
      </el-menu-item>

      <el-menu-item index="/outer/manageAdmin/itemPage">
        <i class="el-icon-star-on"></i>
        <span slot="title">管理员</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'slideNav'
}
</script>

<style scoped>
.el-aside {
  height: 100%;
}
.el-aside > div {
  height: 100%;
}
.el-menu {
  height: 100%;
}
</style>
