<template>
  <el-container>
    <el-header style="border:1px solid black;height:200px;">
      <el-row style="height:100%;">
        <el-col :span="5" class="picture">
          <div>
            <img :src="url" width="80%" />
          </div>
        </el-col>
        <el-col :span="10" class="task">
          <div class="taskId">
            <div>
              <p>{{name}}</p>
            </div>
            <div>
              <el-tag>{{status}}</el-tag>
            </div>
          </div>
          <div class="taskId">
            <p>编号:{{id}}</p>
          </div>
          <div class="taskId">
            <p>申请人:{{user}}</p>
          </div>
        </el-col>
        <el-col :span="9" class="btns">
          <el-button-group>
            <el-button type="primary" icon="el-icon-edit" @click="examine()">审核</el-button>
            <el-button type="primary" icon="el-icon-delete">删除</el-button>
          </el-button-group>
        </el-col>
      </el-row>
    </el-header>
    <el-main style="border:1px solid black;padding:0;">
      <el-row>
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
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'taskDetail',
  data: function () {
    return {
      url:
        'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586064043299&di=936d37ebfc418579e3debf6d674edc82&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg',
      name: '任务标题1231513513',
      status: '未完成',
      id: '123',
      user: 'wang'
    }
  },
  methods: {
    examine () {
      this.$router.push({
        path: '/manageTask/examine',
        query: {
          id: this.id
        }
      })
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
.picture {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.task {
  display: flex;
  flex-direction: column;
}
.taskId {
  display: flex;
  align-items: center;
}
.textDecoration {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-top: 50px;
}
.textDecoration > div {
  margin: 10px 0;
}
.btns {
  display: flex;
  justify-content: flex-end;
}
</style>
