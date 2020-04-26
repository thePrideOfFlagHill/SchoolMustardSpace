<template>
  <div class="manageTask container">
    <h1>任务管理页面</h1>
    <searchBox></searchBox>
    <roughShow ></roughShow>
  </div>
</template>

<script>
import searchBox from '@/components/manageTask/searchBox.vue'
import roughShow from '@/components/manageTask/roughShow.vue'

export default {
  name: 'pageTask',
  components: {
    searchBox,
    roughShow
  }
}
</script>

<style>
.manageTask{
  background: white;
  border: 1px solid black;
}
</style>
