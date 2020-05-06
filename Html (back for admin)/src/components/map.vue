<template>
  <div class="amap-wrapper">
    <el-amap vid="amapDemo" :center="position" :zoom="zoom" class="amap-demo">
      <el-amap-marker vid="marker" :position="position" :label="label"></el-amap-marker>
    </el-amap>
  </div>
</template>

<script>
export default {
  data () {
    return {
      zoom: 16,
      center: [121.406051, 31.179695],
      label: {
        content: ['地点'],
        offset: [10, 10]
      }
    }
  },
  props: ['point'],
  computed: {
    position () {
      var temp = this.point
      for (var i = 0; i < temp.length; i++) {
        temp[i] = parseFloat(temp[i])
      }
      return temp
    }
  },
  mounted: function () {
    console.log(this.position)
  }
}
</script>

<style>
.amap-wrapper {
  width: 95%;
  height: 400px;
  padding: 20px;
  margin-bottom: 10px;
}
</style>
