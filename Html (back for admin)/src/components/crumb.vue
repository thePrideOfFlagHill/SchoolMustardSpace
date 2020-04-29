<template>
  <el-breadcrumb separator="/" class="bread">
    <el-breadcrumb-item
      v-for="(item,index) in breadList"
      :key="index"
      :to="{ path: item.path }"
    >{{item.meta.title}}</el-breadcrumb-item>
  </el-breadcrumb>
</template>

<script>
export default {
  name: 'crumb',
  data () {
    return {
      breadList: [] // 路由集合
    }
  },
  watch: {
    $route () {
      this.getBreadcrumb()
    }
  },
  methods: {
    getBreadcrumb () {
      const matched = this.$route.matched
      // 如果转到任务管理界面
      if (matched.length !== 1) {
      }
      this.breadList = matched
    }
  },
  created () {
    this.getBreadcrumb()
  }
}
</script>

<style scoped>
.bread {
  display: flex;
  align-items: center;
  height: 100%;
  width: 100%;
  margin: 0;
  border-bottom:1px solid gray ;
}
</style>
