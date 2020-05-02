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
        <el-table-column prop="status" label="分类" sortable></el-table-column>
        <el-table-column prop="status" label="访问量" sortable></el-table-column>
        <el-table-column prop="status" label="点赞数" sortable></el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="goDetail(scope.row['id'])" type="text" size="small">查看</el-button>
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
      pageSize: 3, // 每个页面显示多少个项目
      currentPage: 1, // 当前页数
      tableData: [
        {
          name: '名字a',
          url:
            'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586064043299&di=936d37ebfc418579e3debf6d674edc82&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg',
          id: '222333',
          date: '2016-05-02',
          address: '上海市普陀区金沙江路 1518 弄',
          user: '王小虎',
          status: '未完成'
        },
        {
          name: '名字',
          url:
            'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586064043299&di=936d37ebfc418579e3debf6d674edc82&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg',
          id: '222333',
          date: '2016-05-04',
          address: '上海市普陀区金沙江路 1518 弄',
          user: '程小虎',
          status: '完成'
        },
        {
          name: '名',
          url:
            'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586064043299&di=936d37ebfc418579e3debf6d674edc82&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg',
          id: '222333',
          date: '2016-05-02',
          address: '上海市普陀区金沙江路 1518 弄',
          user: '王小虎',
          status: '未完成'
        },
        {
          name: '字',
          url:
            'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586064043299&di=936d37ebfc418579e3debf6d674edc82&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg',
          id: '222333',
          date: '2016-05-04',
          address: '上海市普陀区金沙江路 1518 弄',
          user: '程小虎',
          status: '完成'
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
        path: 'detail',
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
      console.log(oldData)
    }
  },
  components: {
    search: () => import('./search.vue')
  },
  created: function () {}
}
</script>

<style scoped>
.shadow {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  background: white;
}
</style>
