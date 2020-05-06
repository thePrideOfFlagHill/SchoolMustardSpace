<template>
  <el-container>
    <el-header style="height:200px;margin-bottom:10px;" class="shadow">
      <el-row style="height:100%;">
        <el-col :span="4" class="picture">
          <div>
            <el-image style="height:200px;width: 200px;" :src="url" fit="scale-down"></el-image>
          </div>
        </el-col>
        <el-col :span="10" class="task">
          <div class="taskId">
            <div>
              <p>{{name}}</p>
            </div>
            <div style="margin-left:10px;">
              <el-tag>{{status}}</el-tag>
            </div>
          </div>
          <div class="taskId">
            <p>编号:{{id}}</p>
          </div>
          <div class="taskId">
            申请人:
            <el-link type="info" @click="seeUser" :underline="false">
              {{user_id}}
              <i class="el-icon-view el-icon--right"></i>
            </el-link>
          </div>
        </el-col>
        <el-col :span="4" class="btns">
          <el-button-group class="btns">
            <el-button type="primary" icon="el-icon-edit" @click="examine()">审核</el-button>
            <el-button type="primary" icon="el-icon-edit" @click="deleted()">删除</el-button>
          </el-button-group>
        </el-col>
      </el-row>
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
                <div class="textDecoration">开始时间：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{startDate}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">结束时间：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{endDate}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">任务状态</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{isDone}}</div>
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
                <div class="textDecoration">{{label}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">酬劳：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{unitPrice}}</div>
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
                <div class="textDecoration">收藏数</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{collect}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">评论</div>
              </el-col>
              <el-col :span="15">
                <el-button @click="seeComment()">查看评论</el-button>
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
      user: '',
      startDate: '',
      endDate: '',
      decoration: '',
      label: '',
      reword: '',
      thumb_up: '',
      comment: '',
      location: '',
      collect: ''
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
            .post(this.$store.state.headPort + '/api/rental/delete', {
              id: this.id
            })
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
      var that = this
      this.$router.push({
        name: 'leaseComment',
        query: {
          id: that.id
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
          '/api/rental/query/id?id=' +
          this.$route.query.id
      )
      .then(function (response) {
        var data = response.data.data
        that.url = data.image
        that.name = data.title
        that.endDate = data.endTime
        that.unitPrice = data.unitPrice
        that.id = data.id
        that.user_id = data.userId
        that.startDate = data.startTime
        that.isDone = data.isDone === 1 ? '已完成' : '未完成'
        that.decoration = data.content
        that.label = data.label
        that.reword = data.reword
        that.thumb_up = data.thumbUp
        that.comment = data.comment
        that.location = data.location
        that.collect = data.collect
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
