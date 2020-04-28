<template>
  <el-container>
    <el-header style="  border: 1px solid black;">1
        <div>单号：{{id}} 状态：{{status}}</div>
        <div>{{user}} 创建{{name}} {{date}}</div>
    </el-header>
    <el-main style="  border: 1px solid black;">2</el-main>
  </el-container>
</template>

<script>
export default {
  name: 'examine',
  data: function () {
    return {
      id: '123',
      status: '未完成',
      user: '威威',
      name: '打扫教室',
      date: '2017/05/04'
    }
  }
}
</script>
