<template>
  <div :id="'center'">
    <div class="amap-wrapper">
      <el-amap class="amap-box" vid="amap-vue" :center="center">
        <el-amap-marker
          :position="center"
           vid="index"
        ></el-amap-marker>
      </el-amap>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      center: [121.59996, 31.197646]
    }
  }
}
</script>

<style>
.amap-wrapper {
  width: 95%;
  height: 400px;
  padding: 20px;
  margin-bottom:10px;
}
</style>
