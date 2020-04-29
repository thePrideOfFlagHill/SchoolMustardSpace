<template>
  <el-container>
    <el-header class="shortInfo" height="100px">
      <el-row>
        <el-col :span="6">
          <p>任务单号：{{id}}</p>
        </el-col>
        <el-col :span="6">
          <p>状态：{{status}}</p>
        </el-col>
      </el-row>
      <div>
        <el-row>
          <el-col :span="6">
            <p>{{user}} 创建{{name}}</p>
          </el-col>
          <el-col :span="6">
            <p>{{date}}</p>
          </el-col>
          <el-col :span="12" class="btns">
            <el-button-group>
              <el-button type="primary" icon="el-icon-edit" >通过</el-button>
              <el-button type="primary" icon="el-icon-delete">拒绝</el-button>
            </el-button-group>
          </el-col>
        </el-row>
      </div>
    </el-header>
    <el-main class="longInfo">
      <el-col>
        <el-col :span="2">
          <div>
            <el-divider direction="vertical"></el-divider>任务详情
          </div>
        </el-col>
        <el-col :span="10" class="textDecoration">
          <div>
            <label>标题</label>
          </div>
          <div>
            <label>起止时间</label>
          </div>
          <div>
            <label>任务描述</label>
          </div>

          <div>
            <label>标签</label>
          </div>

          <div>
            <label>酬劳</label>
          </div>

          <div>
            <label>联系方式</label>
          </div>
        </el-col>
        <el-col :span="10">
          <el-col :span="2">
            <div>
              <el-divider direction="vertical"></el-divider>地图
            </div>
          </el-col>
        </el-col>
      </el-col>
    </el-main>
    <el-footer>
      <el-row>
        <el-col :span="2">备注:</el-col>
        <el-col :span="10">
          <el-input
            type="textarea"
            :autosize="{ minRows: 2, maxRows: 4}"
            placeholder="请输入内容"
          ></el-input>
        </el-col>
      </el-row>
    </el-footer>
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
  },
  // 初始化函数
  created: function () {
    console.log(this.$route.query.id)
    // 根据id访问接口获取数据
  }
}
</script>

<style scoped>
.textDecoration {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-top: 50px;
}
.textDecoration > div {
  margin: 10px 0;
}
.shortInfo {
  border: 1px solid black;
  margin-bottom: 10px;
}
.longInfo {
  border: 1px solid black;
  padding: 0;
}
.btns {
  display: flex;
  justify-content: flex-end;
}
</style>
