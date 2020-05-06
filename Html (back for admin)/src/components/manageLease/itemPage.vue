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
        <el-table-column prop="id" label="简述" width="500">
          <template slot-scope="scope">
            <el-row :gutter="20">
              <el-col :span="10">
                <img :src="scope.row['img']" width="100%" />
              </el-col>
              <el-col :span="10">
                <label>标题：</label>
                <div>{{scope.row['title']}}</div>
                <div>
                  <label>编号：</label>
                  <div>{{scope.row['id']}}</div>
                </div>
              </el-col>
            </el-row>
          </template>
        </el-table-column>
        <el-table-column prop="start_time" label="起始时间" sortable></el-table-column>
        <el-table-column prop="user_id" label="用户编号" sortable></el-table-column>
        <el-table-column prop="status" label="状态" sortable></el-table-column>
        <el-table-column prop="comment" label="评论数" sortable></el-table-column>
        <el-table-column prop="collect" label="收藏数" sortable></el-table-column>
        <el-table-column prop="thumb_up" label="点赞数" sortable></el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="goDetail(scope.row)" type="text" size="small">查看</el-button>
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
    goDetail (that) {
      var arry = that.location.split(',')
      var temp = arry.reverse()
      this.$router.push({
        path: 'detail',
        query: {
          id: that.id,
          location: temp
        }
      })
    },
    // 翻页
    pageChange (currentPage) {
      this.currentPage = currentPage
    },
    // 调出全部数据
    allData () {
      var tableData = this.tableData
      this.$axios
        .get(this.$store.state.headPort + '/api/rental/query/all')
        .then(function (response) {
          var data = response.data.data
          for (var i = 0; i < data.length; i++) {
            var sum = {}
            sum.id = data[i].id
            sum.title = data[i].title
            sum.img = data[i].image
            sum.start_time = data[i].startTime
            sum.location = data[i].location
            sum.user_id = data[i].userId
            sum.status = '未完成'
            sum.comment = data[i].comment
            sum.collect = data[i].collect
            sum.thumb_up = data[i].thumbUp
            tableData.push(sum)
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    // 删除全部任务
    delAll () {
      var that = this
      console.log(that.dataLength)
      for (var i = 0; i < that.tableData.length; i++) {
        this.$axios
          .post(
            this.$store.state.headPort +
              '/api/rental/delete?id=' +
              that.tableData[i].id
          )
          .then(function (response) {
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
          })
          .catch(function (error) {
            console.log(error)
          })
      }
    }
  },
  watch: {
    // 监听条件数据的变化
    option (newData, oldData) {
      // 设置表格搜索条件 进行接口访问获取数据
      this.tableData = []
      var port = null
      if (newData.contentType === '项目编号') {
        port = '/api/rental/query/id?id='
      } else if (newData.contentType === '用户编号') {
        port = '/api/rental/query/userId?userId='
      } else if (newData.contentType === '标题') {
        port = '/api/rental/query/like/title?text='
      } else if (newData.contentType === '内容') {
        port = '/api/rental/query/like/content?text='
      } else if (newData.contentType === '标签') {
        port = '/api/rental/query/like/label?text='
      }
      var page = this
      if (newData.content === '') {
        page.allData()
      } else {
        this.$axios
          .get(this.$store.state.headPort + port + newData.content)
          .then(function (response) {
            var data = response.data.data
            console.log(data)

            if (data.length >= 1) {
              for (var i = 0; i < data.length; i++) {
                var sum = {}
                sum.id = data[i].id
                sum.title = data[i].title
                sum.img = data[i].image
                sum.start_time = data[i].startTime
                sum.location = data[i].location
                sum.user_id = data[i].userId
                sum.status = '未完成'
                sum.comment = data[i].comment
                sum.collect = data[i].collect
                sum.thumb_up = data[i].thumbUp
                page.tableData.push(sum)
              }
            } else if (data.id) {
              var sun = {}
              sun.id = data.id
              sun.title = data.title
              sun.img = data.image
              sun.start_time = data.startTime
              sun.location = data.location
              sun.user_id = data.userId
              sun.comment = data.comment
              sun.collect = data.collect
              sun.status = '未完成'
              sun.thumb_up = data.thumbUp

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
