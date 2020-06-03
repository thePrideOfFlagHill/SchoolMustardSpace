<template>
  <el-container>
    <el-main class="shadow">
      <el-row>
        <el-col :span="12" class="marginBottom">
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">内容：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{content}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">发布时间：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{publish_time}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">所属项目编号：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{table_id}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">点赞数</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{thumb_up}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">评论数</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{comment}}</div>
              </el-col>
            </el-row>
          </div>
        </el-col>
        <el-col :span="12">
          <div style="width:90%;margin:5%;" class="shadow">
            <Map :point="location"></Map>
          </div>
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
      url: '',
      name: '',
      status: '',
      id: '',
      user_id: '',
      startDate: '',
      endDate: '',
      decoration: '',
      label: '',
      reword: '',
      thumb_up: '',
      comment: '',
      location: '',
      collect: '',
      type: ''
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
          var that = this
          this.$axios
            .post(this.$store.state.headPort + '/api/task/comment/delete?id=' + that.id)
            .then(function (response) {
              that.$alert('删除成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  that.$router.go(-1)
                }
              })
            })
            .catch(function (error) {
              console.log(error)
            })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
    // 查看相关评论
    seeComment () {
      this.$router.push({
        name: 'commentPage',
        params: {
          id: this.user_id
        }
      })
    },
    // 查看用户信息
    seeUser () {
      var that = this
      console.log(that.user_id)
      this.$router.push({
        name: 'userDetail',
        query: {
          id: this.user_id
        }
      })
    },
    // 查看接收者信息
    seeAccept () {
      this.$router.push({
        name: 'userDetail',
        params: {
          id: this.id
        }
      })
    }
  },
  // 初始化函数
  created: function () {
    this.location = this.$route.query.location
    // 根据id访问接口获取数据
    var that = this
    this.$axios
      .get(
        this.$store.state.headPort +
          '/api/query/lostfound/comment/id/' +
          this.$route.query.id
      )
      .then(function (response) {
        var data = response.data.data
        that.id = data.id
        that.user_id = data.user_id
        that.publish_time = data.publish_time
        that.content = data.content
        that.table_id = data.table_id
        that.thumb_up = data.thumb_up
        that.comment = data.comment
      })
      .catch(function (error) {
        console.log(error)
      })
  },
  components: {
    Map: () => import('../map.vue')
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

.shadow {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background: white;
}
.btns {
  float: right;
}
.textDecoration {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  padding: 10px;
}
.marginBottom > div {
  margin-bottom: 20px;
}
</style>
