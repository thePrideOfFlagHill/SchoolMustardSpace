<template>
  <el-row :gutter="10">
    <el-col :span="4">
      <el-input v-model="infos.content" placeholder="输入" class="width"></el-input>
    </el-col>
    <el-col :span="4">
      <el-dropdown @command="handleCommand">
        <el-button type="primary">
          {{infos.contentType}}
          <i class="el-icon-arrow-down el-icon--right"></i>
        </el-button>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="项目编号">项目编号</el-dropdown-item>
          <el-dropdown-item command="用户编号">用户编号</el-dropdown-item>
          <el-dropdown-item command="标题">标题</el-dropdown-item>
          <el-dropdown-item command="内容">内容</el-dropdown-item>
          <el-dropdown-item command="标签">标签</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-col>
    <el-col :span="3">
      <el-popover placement="bottom" width>
        <div style="text-align: right; margin: 0">
          <div class="inline">
            <el-select v-model="value" placeholder="任务状态" class="width">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </div>
          <div class="inline">
            <el-select v-model="infos.type" placeholder="用户种类" class="width">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </div>
          <div class="inline">
            <el-input v-model="infos.user" placeholder="用户姓名" class="width"></el-input>
          </div>
          <div class="inline">
            <el-date-picker v-model="infos.date" type="date" placeholder="起始时间" class="width"></el-date-picker>
          </div>
        </div>
        <el-button slot="reference">详细条件</el-button>
      </el-popover>
    </el-col>
    <el-col :span="3">
      <el-button type="primary" icon="el-icon-search" @click="sendInfo()">搜索</el-button>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: 'serachBox',
  data () {
    return {
      infos: {
        date: '',
        type: '',
        user: '',
        id: '',
        content: '',
        contentType: '用户编号'
      },
      options: [
        {
          value: '选项1',
          label: '黄金糕'
        },
        {
          value: '选项2',
          label: '双皮奶'
        },
        {
          value: '选项3',
          label: '蚵仔煎'
        },
        {
          value: '选项4',
          label: '龙须面'
        },
        {
          value: '选项5',
          label: '北京烤鸭'
        }
      ],
      value: ''
    }
  },
  methods: {
    sendInfo () {
      this.$store.commit('setOption', this.infos)
    },
    handleCommand (command) {
      this.infos.contentType = command
    }
  },
  watch: {
    infos: {
      handler: function () {
        this.sendInfo()
      },
      deep: true
    }
  },
  mounted: function () {
    if (this.$route.query.id !== (null || undefined)) {
      this.infos.content = this.$route.query.id
    }
  }
}
</script>

<style scoped>
.searchBoxForm {
  margin: 10px 0;
}
.inline {
  display: flex;
  align-items: center;
  margin: 10px 0;
  justify-content: space-around;
}
.width {
  width: 80%;
}
</style>
