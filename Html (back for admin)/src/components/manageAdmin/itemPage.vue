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
        <el-table-column prop="type" label="类型" sortable></el-table-column>
        <el-table-column prop="setDate" label="创建时间" sortable></el-table-column>
        <el-table-column prop="loginDate" label="最后登录时间" sortable></el-table-column>
        <el-table-column prop="status" label="状态" sortable></el-table-column>
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
      pageSize: 1, // 每个页面显示多少个项目
      currentPage: 1, // 当前页数
      tableData: [
        {
          name: '名字',
          id: '222333',
          setDate: '2016-05-02',
          loginDate: '2020-04-01',
          user: '王小虎',
          status: '未完成',
          type: '超级管理员'
        },
        {
          name: '名字',
          id: '222333',
          setDate: '2016-05-02',
          loginDate: '2020-04-01',
          user: '王小虎',
          status: '未完成',
          type: '超级管理员'
        }
      ]
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
        path: '/outer/manageAdmin/detail',
        query: {
          id: id
        }
      })
    },
    goChange (id) {
      this.$router.push({
        path: '/outer/manageAdmin/change',
        query: {
          id: id
        }
      })
    },
    // 翻页
    pageChange (currentPage) {
      this.currentPage = currentPage
    }
  },
  watch: {
    // 监听条件数据的变化
    option (newData, oldData) {
      // 设置表格搜索条件 进行接口访问获取数据
    }
  },
  components: {
    search: () => import('./search.vue')
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
