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
        <el-col :span="4" class="btns">
          <el-button-group class="btns">
            <el-button type="primary" icon="el-icon-edit" @click="pass">通过</el-button>
            <el-button type="primary" icon="el-icon-delete" @click="refuse">拒绝</el-button>
          </el-button-group>
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
        </el-row>
      </div>
    </el-header>
    <el-main class="shadow">
      <el-row>
        <el-col :span="12" class="marginBottom">
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">标题：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{name}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">起止时间：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{startDate}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">任务描述：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{decoration}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">标签：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">标签：</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">酬劳：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">酬劳：</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">联系方式：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">联系方式：</div>
              </el-col>
            </el-row>
          </div>
        </el-col>
        <el-col :span="12" class="box">
          <div style="width:90%;" class="shadow">
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
    console.log(this.$route.path)

    // console.log(this.$route.query.id)
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

.shortInfo {
  background: lightblue;
  color: white;
  margin-bottom: 10px;
}
.btns {
  float: right;
  height: 100%;
}
p {
  text-align: left;
  padding-left: 10px;
}
.textDecoration {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);

  padding: 10px;
}
.marginBottom > div {
  margin-top: 10px;
  margin-bottom: 20px;
}
</style>
