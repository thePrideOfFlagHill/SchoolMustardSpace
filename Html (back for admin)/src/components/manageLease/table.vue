<template>
  <el-container>
    <el-header>
      <search></search>
    </el-header>
    <el-main>
      <el-table
        :data="tableData"
        style="width: 100%"
        :default-sort="{prop: 'date', order: 'descending'}"
      >
        <el-table-column prop="id" label="简述" sortable width="500">
          <template slot-scope="scope">
            <el-row :gutter="20">
              <el-col :span="10">
                <img :src="scope.row['url']" width="100%" />
              </el-col>
              <el-col :span="10">
                <div>{{scope.row['name']}}</div>
                <div>
                  <label>编号</label>
                  <div>{{scope.row['id']}}</div>
                </div>
              </el-col>
            </el-row>
          </template>
        </el-table-column>
        <el-table-column prop="date" label="起始时间" sortable></el-table-column>
        <el-table-column prop="address" label="地址" :formatter="formatter"></el-table-column>
        <el-table-column prop="user" label="发布人" sortable></el-table-column>
        <el-table-column prop="status" label="状态" sortable></el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="goDetail(scope.row['id'])" type="text" size="small">查看</el-button>
            <el-button type="text" size="small">编辑</el-button>
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
          url:
            'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586064043299&di=936d37ebfc418579e3debf6d674edc82&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg',
          id: '222333',
          date: '2016-05-02',
          address: '上海市普陀区金沙江路 1518 弄',
          user: '王小虎',
          status: '未完成'
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
        path: '/manageTask/detail',
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
</style>
