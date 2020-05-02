<template>
  <el-container>
    <el-main class="longInfo shadow">
      <el-row>
        <el-col :span="12" class="box">
          <div>
            <label class="leftTitle">用户详情</label>
          </div>
          <div>

          </div>
          <div class="textDecoration" style="margin-top:80px;">
            <label>头像：</label>
          </div>
          <div>
            <el-image style="width: 70%; " :src="url" fit="fill"></el-image>
          </div>
          <div class="textDecoration">
            <label>用户名：</label>
          </div>
          <div class="textDecoration">
            <label>创建时间:</label>
          </div>
          <div class="textDecoration">
            <label>用户签名：</label>
          </div>
          <div class="textDecoration">
            <label>标签：</label>
          </div>
          <div class="textDecoration">
            <label>联系方式：</label>
          </div>
          <div class="textDecoration">
            <label>点赞数:</label>
          </div>
          <div class="textDecoration">
            <el-button @click="seeComment()">查看发布的评论</el-button>
          </div>
          <div class="textDecoration">
            <el-button @click="seeComment()">查看发布任务</el-button>
            <el-button @click="seeComment()">查看发布租赁</el-button>
            <el-button @click="seeComment()">查看发布失物</el-button>
          </div>
          <div class="textDecoration">
            <el-button @click="seeComment()">查看接受任务</el-button>
            <el-button @click="seeComment()">查看接受租赁</el-button>
            <el-button @click="seeComment()">查看接受失物</el-button>
          </div>
        </el-col>
        <el-col :span="12" class="box"></el-col>
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
    // 审核
    examine () {
      this.$router.push({
        path: 'examine',
        query: {
          id: this.id
        }
      })
    },
    // 删除
    deleted () {
      this.$confirm('此操作将永久删除该任务, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          // 访问接口删除
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
    seeComment () {
      this.$router.push({
        name: 'commentPage',
        params: {
          id: this.id
        }
      })
    }
  },
  // 初始化函数
  created: function () {
    // console.log(this.$route.query.id)
    // 根据id访问接口获取数据
  },
  components: {}
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
  height: 100%;
}
.task > div {
  height: 30%;
  margin: 1% 0;
}
.taskId {
  display: flex;
  align-items: center;
}
.box {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  position: relative;
}
.shadow {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background: white;
}
.btns {
  display: flex;
  justify-content: flex-end;
}
.textDecoration {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  margin-top: 25px;
  margin-left: 40px;
  padding: 10px;
}
.leftTitle {
  border-left: 3px solid gainsboro;
  position: absolute;
  top: 0px;
  padding: 10px;
}
.longInfo {
  border-bottom: 0;
  padding: 0;
}
</style>
