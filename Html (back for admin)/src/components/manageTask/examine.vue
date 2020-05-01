<template>
  <el-container>
    <el-header class="shortInfo shadow" height="100px">
      <el-row>
        <el-col :span="3">
          <p>任务单号：{{id}}</p>
        </el-col>
        <el-col :span="3">
          <p>状态：{{status}}</p>
        </el-col>
      </el-row>
      <div>
        <el-row>
          <el-col :span="3">
            <p>{{user}} 创建{{name}}</p>
          </el-col>
          <el-col :span="3">
            <p>{{date}}</p>
          </el-col>
          <el-col :span="18" class="btns">
            <el-button-group>
              <el-button type="primary" icon="el-icon-edit" @click="pass">通过</el-button>
              <el-button type="primary" icon="el-icon-delete" @click="refuse">拒绝</el-button>
            </el-button-group>
          </el-col>
        </el-row>
      </div>
    </el-header>
    <el-main class="longInfo shadow">
      <el-row>
        <el-col :span="12" class="box">
          <div>
            <label class="leftTitle">任务详情</label>
          </div>
          <div class="textDecoration" style="margin-top:80px;">
            <label>标题：</label>
          </div>
          <div class="textDecoration">
            <label>起止时间:</label>
          </div>
          <div class="textDecoration">
            <label>任务描述：</label>
          </div>
          <div class="textDecoration">
            <label>标签：</label>
          </div>
          <div class="textDecoration">
            <label>酬劳：</label>
          </div>
          <div class="textDecoration">
            <label>联系方式：</label>
          </div>
        </el-col>
        <el-col :span="12" class="box">
          <div style="margin-top:30px;">
            <label class="leftTitle">地图</label>
          </div>
          <div style="width:90%;margin:5%;;" class="shadow">
            <Map></Map>
          </div>
        </el-col>
      </el-row>
    </el-main>
    <el-footer>
      <el-row>
        <el-col :span="2">备注:</el-col>
        <el-col :span="10">
          <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容"></el-input>
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
  methods: {
    pass () {
      this.$message({
        message: '审核成功',
        type: 'success'
      })
    },
    refuse () {
      this.$prompt('拒绝的理由', '', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputErrorMessage: '不能为空'
      })
        .then(({ value }) => {
          this.$message({
            type: 'success',
            message: '提交成功: ' + value
          })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          })
        })
    }
  },
  // 初始化函数
  created: function () {
    console.log(this.$route.query.id)
    // 根据id访问接口获取数据
  },
  components: {
    Map: () => import('../map.vue')
  }
}
</script>

<style scoped>
.el-main,
.el-footer {
  background: white;
  border: 1px solid gainsboro;
}
.box {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  position: relative;
}
.shadow {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  background: white;
}
.leftTitle {
  border-left: 3px solid gainsboro;
  position: absolute;
  top: 0px;
  padding: 10px;
}
.shortInfo {
  background: lightblue;
  color: white;
  margin-bottom: 10px;
}
.longInfo {
  border-bottom: 0;
  padding: 0;
}
.btns {
  display: flex;
  justify-content: flex-end;
}
p {
  text-align: left;
  padding-left: 10px;
}
.textDecoration {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  margin-top: 30px;
  margin-left: 40px;
  padding: 10px;
}
</style>
