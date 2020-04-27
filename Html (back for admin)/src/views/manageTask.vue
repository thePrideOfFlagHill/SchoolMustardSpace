<template>
  <div class="manageTask container">
    <h1>任务管理页面</h1>
    <router-link to='/manageTask/itemPage'>表单</router-link>
    <router-view></router-view>
  </div>
</template>

<script>

</script>

<style scoped>
.manageTask{
  background: whitesmoke;
  border: 1px solid black;
}
hr{
  margin: 10px 0;
}

</style>
