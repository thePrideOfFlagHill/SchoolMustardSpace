<template>
  <el-row :gutter="20">
    <el-col :span="4">
      <el-input v-model="infos.id" placeholder="输入管理员编号" class="width"></el-input>
    </el-col>
    <el-col :span="3">
      <el-popover placement="bottom" width>
        <div style="text-align: right; margin: 0">
          <div class="inline">
            <p>任务状态：</p>
            <el-select v-model="value" placeholder="请选择" class="width">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </div>
          <div class="inline">
            <p>用户种类：</p>
            <el-select v-model="infos.type" placeholder="请选择" class="width">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </div>
          <div class="inline">
            <p>用户姓名：</p>
            <el-input v-model="infos.user" placeholder="请输入内容" class="width"></el-input>
          </div>
          <div class="inline">
            <p>选择日期：</p>
            <el-date-picker v-model="infos.date" type="date" placeholder="选择日期" class="width"></el-date-picker>
          </div>
        </div>
        <el-button slot="reference">详细条件</el-button>
      </el-popover>
    </el-col>
    <el-col :span="3">
      <el-button type="primary" icon="el-icon-search" @click="sendInfo()">搜索</el-button>
    </el-col>
    <el-col :span="3" :offset="10">
      <el-button type="primary" icon="el-icon-edit" @click="increaseAdmin()">新增管理员</el-button>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: 'serachBox',
  data () {
    return {
      infos: {
        date: 'date',
        type: '',
        user: '',
        id: ''
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
    increaseAdmin () {
      this.$router.push('increase')
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
