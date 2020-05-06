<template>
  <el-container>
    <el-main class="longInfo shadow">
      <el-row>
        <el-col :span="12">
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">头像：</div>
              </el-col>
              <el-col :span="15">
                            <el-image style="height:200px;width: 200px;" :src="head" fit="scale-down"></el-image>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="5">
                <div class="textDecoration">用户名：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{name}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="5">
                <div class="textDecoration">账号</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{accountNumber}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="5">
                <div class="textDecoration">用户签名：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{info}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="5">
                <div class="textDecoration">联系方式：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{phoneNumber}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="5">
                <div class="textDecoration">性别：</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{sex}}</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="5">
                <div class="textDecoration">地址</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">{{address}}</div>
              </el-col>
            </el-row>
          </div>
          <div style="  margin: 20px;">
            <el-popover placement="right" width="500" trigger="click">
              <div class="exBtns">
                <el-button-group v-show="false">
                  <el-button @click="seeComment()">查看发布的评论</el-button>
                </el-button-group>
                <el-button-group>
                  <el-button @click="seeTask()">查看发布任务</el-button>
                  <el-button @click="seeLease()">查看发布租赁</el-button>
                  <el-button @click="seeLost()">查看发布失物</el-button>
                </el-button-group>
              </div>
              <el-button slot="reference">更多相关信息</el-button>
            </el-popover>
          </div>
        </el-col>
        <el-col :span="12" class="box">
          <el-button type="primary" icon="el-icon-edit" @click="deleted()">删除</el-button>
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
      head: '',
      name: '',
      status: '',
      id: '',
      user: '',
      accountNumber: '',
      address: '',
      sex: '',
      info: '',
      phoneNumber: ''
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
    // 查看相关信息按钮
    seeComment () {
      var that = this

      this.$router.push({
        name: 'taskComment',
        query: {
          id: that.user_id
        }
      })
    },
    seeTask () {
      var that = this
      this.$store.commit('setContenttype', '用户编号')

      this.$router.push({
        name: 'manageTask',
        query: {
          id: that.user_id
        }
      })
    },
    seeLease () {
      var that = this
      console.log(that.user_id)
      this.$router.push({
        name: 'manageLease',
        query: {
          id: that.user_id
        }
      })
    },
    seeLost () {
      var that = this

      this.$router.push({
        name: 'manageLost',
        query: {
          id: that.user_id
        }
      })
    },
    // 删除用户
    deleted () {
      this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          // 访问接口删除
          var that = this
          this.$axios
            .post(
              this.$store.state.headPort +
                '/api/user/delete?accountNumber=' +
                that.accountNumber
            )
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
    }
  },
  // 初始化函数
  mounted: function () {
    // 根据id访问接口获取数据
    var that = this
    this.$axios
      .get(
        this.$store.state.headPort +
          '/api/user/query/id/' +
          this.$route.query.id
      )
      .then(function (response) {
        var data = response.data.data
        var str = data.id
        that.user_id = str
        that.head = data.head
        that.name = data.name
        that.phoneNumber = data.phoneNumber == null ? '暂无' : data.phoneNumber
        that.accountNumber = data.accountNumber
        that.sex = data.sex === 0 ? '男' : '女'
        that.address = data.address == null ? '暂无' : data.address
        that.info = data.info == null ? '暂无' : data.info
        that.id = data.id
      })
      .catch(function (error) {
        console.log(error)
      })
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
  justify-content: right;
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
.exBtns button {
  margin: 10px;
}
</style>
