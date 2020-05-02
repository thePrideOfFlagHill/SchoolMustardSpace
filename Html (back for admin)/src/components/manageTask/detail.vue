<template>
  <el-container>
    <el-header style="height:200px;margin-bottom:10px;" class="shadow">
      <el-row style="height:100%;">
        <el-col :span="4" class="picture">
          <div>
            <el-image style="width: 70%; " :src="url" fit="fill"></el-image>
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
              {{user}}
              <i class="el-icon-view el-icon--right"></i>
            </el-link>
          </div>
        </el-col>
        <el-col :span="4" class="btns">
          <el-button-group class="btns">
            <el-button type="primary" icon="el-icon-edit" @click="examine()">审核</el-button>
            <el-button type="primary" icon="el-icon-delete" @click="deleted()">删除</el-button>
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
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">点赞数</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">点赞数</div>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="4">
                <div class="textDecoration">接收人编号</div>
              </el-col>
              <el-col :span="15">
                <div class="textDecoration">
                  <el-link type="info" @click="seeAccept" :underline="false">
                    {{user}}
                    <i class="el-icon-view el-icon--right"></i>
                  </el-link>
                </div>
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
            <Map></Map>
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
      url:
        'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586064043299&di=936d37ebfc418579e3debf6d674edc82&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg',
      name: '任务标题1231513513',
      status: '未完成',
      id: '123',
      user: 'wang',
      startDate: '1900-01-03',
      endDate: '2020-04-05',
      decoration: '这是一项艰巨的任务'
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
    // 查看相关评论
    seeComment () {
      this.$router.push({
        name: 'commentPage',
        params: {
          id: this.id
        }
      })
    },
    // 查看用户信息
    seeUser () {
      this.$router.push({
        name: 'userDetail',
        params: {
          id: this.id
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
    // console.log(this.$route.query.id)
    // 根据id访问接口获取数据
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
