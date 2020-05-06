<template>
  <el-container>
    <el-header>
      <search></search>
    </el-header>
    <el-main class="shadow">
      <el-table
        :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
        style="width: 100%"
        :default-sort="{prop: 'date', order: 'descending'}"
      >
        <el-table-column prop="name" label="名称" sortable></el-table-column>
        <el-table-column prop="id" label="编号" sortable></el-table-column>
        <el-table-column prop="accountNumber" label="账号" sortable></el-table-column>
        <el-table-column prop="type" label="类型" sortable></el-table-column>
        <el-table-column prop="setDate" label="创建时间" sortable></el-table-column>
        <el-table-column prop="loginDate" label="最后登录时间" sortable></el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="goDetail(scope.row['accountNumber'])" type="text" size="small">查看</el-button>
            <el-button @click="goChange(scope.row['accountNumber'])" type="text" size="small" v-show="false">编辑</el-button>
            <template>
              <el-popconfirm title="确定删除管理员吗？" @onConfirm="goDelete(scope.row['accountNumber'])">
                <el-button slot="reference" type="text">删除</el-button>
              </el-popconfirm>
            </template>
            <el-button @click="goReset(scope.row['accountNumber'])" type="text" size="small">重置密码</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
    <el-footer>
      <el-pagination
        background
        layout="prev, pager, next"
        :total="dataLength"
        :current-page="currentPage"
        :page-size="pageSize"
        @current-change="pageChange"
      ></el-pagination>
    </el-footer>
  </el-container>
</template>

<script>
export default {
  data () {
    return {
      pageSize: 10, // 每个页面显示多少个项目
      currentPage: 1, // 当前页数
      tableData: []
    }
  },
  computed: {
    // 表格搜索条件
    option () {
      return this.$store.state.option
    },
    // 返回数组长度
    dataLength () {
      return this.tableData.length
    }
  },
  methods: {
    formatter (row, column) {
      return row.address
    },
    // 点击跳转到详细页面（带id参数）
    goDetail (accountNumber) {
      this.$router.push({
        path: '/outer/manageAdmin/detail',
        query: {
          accountNumber: accountNumber
        }
      })
    },
    goChange (accountNumber) {
      this.$router.push({
        path: '/outer/manageAdmin/change',
        query: {
          id: accountNumber
        }
      })
    },
    goDelete (accountNumber) {
      var that = this
      this.$axios
        .post(
          this.$store.state.headPort +
            '/api/admin/delete?accountNumber=' +
            accountNumber
        )
        .then(function (response) {
          that.$alert('删除成功', '', {
            confirmButtonText: '确定',
            callback: action => {
              that.$router.go(0)
            }
          })
        })
    },
    goReset (accountNumber) {
      this.$prompt('请输入新密码', '修改密码', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      })
        .then(({ value }) => {
          this.$axios
            .post(this.$store.state.headPort + '/api/admin/update', {
              accountNumber: accountNumber,
              password: value,
              authority: '2'
            })
            .then(function (response) {
              this.$message({
                type: 'success',
                message: '重置成功!'
              })
            })
          this.$message({
            type: 'success',
            message: '你的新密码是: ' + value
          })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          })
        })
    },

    // 翻页
    pageChange (currentPage) {
      this.currentPage = currentPage
    },
    // 获取全部数据
    allData () {
      var tableData = this.tableData
      this.$axios
        .get(this.$store.state.headPort + '/api/admin/query/all')
        .then(function (response) {
          var data = response.data.data

          for (var i = 0; i < data.length; i++) {
            var sum = {}
            sum.accountNumber = data[i].accountNumber
            sum.id = data[i].id

            sum.name = '管理员'
            sum.setDate = '2016-05-02'
            sum.loginDate = '2020-04-01'
            sum.type = '超级管理员'

            tableData.push(sum)
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },
  watch: {
    // 监听条件数据的变化
    option (newData, oldData) {
      // 设置表格搜索条件 进行接口访问获取数据
      this.tableData = []
      var page = this
      if (newData.id === '') {
        page.allData()
      } else {
        this.$axios
          .get(
            this.$store.state.headPort +
              '/api/admin/query/accountNumber/' +
              newData.id
          )
          .then(function (response) {
            var data = response.data.data
            var sun = {}
            sun.accountNumber = data.accountNumber
            sun.id = data.id
            sun.name = '管理员'
            sun.setDate = '2016-05-02'
            sun.loginDate = '2020-04-01'
            sun.type = '超级管理员'
            page.tableData.push(sun)
          })
          .catch(function (error) {
            console.log(error)
          })
      }
    }
  },
  components: {
    search: () => import('./search.vue')
  },
  mounted: function () {
    this.allData()
  }
}
</script>

<style scoped>
.el-table {
  margin-top: 20px;
}
.shadow {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  background: white;
}
</style>
