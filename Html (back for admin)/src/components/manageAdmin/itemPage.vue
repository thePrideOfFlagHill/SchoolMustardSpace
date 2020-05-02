<template>
  <el-container>
    <el-header>
      <search></search>
    </el-header>
    <el-main class="shadow">
      <el-table
        :data="tableData"
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
            <el-button @click="goChange(scope.row['id'])" type="text" size="small" >编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
export default {
  data () {
    return {
      tableData: [
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
