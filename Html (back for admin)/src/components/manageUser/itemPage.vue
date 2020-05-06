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
        <el-table-column prop="id" label="头像">
          <template slot-scope="scope">
            <el-row :gutter="20">
              <el-col :span="18">
                <img :src="scope.row['url']" width="100%" />
              </el-col>
            </el-row>
          </template>
        </el-table-column>
        <el-table-column prop="accountNumber" label="账号" sortable></el-table-column>
        <el-table-column prop="address" label="地址" :formatter="formatter"></el-table-column>
        <el-table-column prop="name" label="用户名" sortable></el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="goDetail(scope.row['id'])" type="text" size="small">查看</el-button>
            <el-button @click="goChange(scope.row['id'])" type="text" size="small">编辑</el-button>
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
    goDetail (id) {
      this.$router.push({
        path: 'detail',
        query: {
          id: id
        }
      })
    },
    goChange (id) {
      this.$router.push({
        path: 'change',
        query: {
          id: id
        }
      })
    },
    // 翻页
    pageChange (currentPage) {
      this.currentPage = currentPage
    },
    allData () {
      var tableData = this.tableData
      this.$axios
        .get(this.$store.state.headPort + '/api/user/query/all')
        .then(function (response) {
          var data = response.data.data
          for (var i = 0; i < data.length; i++) {
            var sum = {}
            sum.accountNumber = data[i].accountNumber
            sum.id = data[i].id

            sum.name = data[i].name
            sum.url = data[i].head
            sum.address = data[i].address
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
      console.log(newData)
      this.tableData = []
      var page = this
      if (newData.id === '') {
        page.allData()
      } else {
        this.$axios
          .get(
            this.$store.state.headPort +
              '/api/user/query/accountNumber/' +
              newData.id
          )
          .then(function (response) {
            var data = response.data.data

            if (response.data.length > 1) {
              for (var i = 0; i < data.length; i++) {
                var sum = {}
                sum.accountNumber = data[i].accountNumber
                sum.name = data[i].name
                sum.url = data[i].head
                sum.address = data[i].address
                page.tableData.push(sum)
              }
            } else if (data.id !== undefined) {
              var sun = {}
              sun.accountNumber = data.accountNumber
              sun.name = data.name
              sun.url = data.head
              sun.address = data.address
              page.tableData.push(sun)
            }
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
.shadow {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  background: white;
}
</style>
