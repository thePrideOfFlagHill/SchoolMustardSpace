<template>
  <d2-container>
    <template slot="header">
      <el-row :gutter="20">
        <el-col :span="8">搜索任务</el-col>
        <el-col :span="6" class="d2-text-center">
          <el-input v-model="input" placeholder="按标题搜索" size="small"></el-input>
        </el-col>
        <el-col :span="6" style="cursor:pointer;margin-top:0px">
          <el-button icon="el-icon-search" type="primary" size="small" @click="goSearch">搜索</el-button>
        </el-col>
        <el-col :span="2" class="d2-text-center" style="cursor:pointer;">
          <el-button @click="goToInsert">我要发布</el-button>
        </el-col>
        <el-col :span="2" class="d2-text-center" style="cursor:pointer;">
          <el-button @click="goToMy">我的任务</el-button>
        </el-col>
      </el-row>
    </template>

    <work-list :data="formData" class="work-list" @clickItem="goToWorkDetail"></work-list>
  </d2-container>
</template>

<script>
import WorkList from "@/components/worklist/workList";
import { GetWorkList } from "@/api/work/work";
import axios from "axios";
// import axios from
export default {
  name: "page1",
  components: {
    WorkList
  },
  methods: {
    async getWorkLits() {
      var { data } = await axios.get("/api/task/query/all");
      // console.log(data);
      if (data.status == 200) this.formatData = data.data;
      console.log(this.formatData);
    },
    goToWorkDetail(item) {
      this.$router.push({
        name: "page4",
        params: {
          data: item
        }
      });
    },
    goToInsert() {
      this.$router.push({ name: "page2" });
    },
    goToMy() {
      this.$router.push({ name: "page3" });
    },
    goSearch() {
      let that=this
      axios
        .get("/api/task/query/like/title?title=" + this.input)
        .then(function(res) {
          console.log(res.data.data);
          if (res.data.status == 200) that.formatData = res.data.data;
          console.log(that.formatData);
        });
    }
  },
  created() {
    this.getWorkLits();
  },
  data() {
    return {
      input: "",
      formatData: ""
    };
  },
  computed: {
    formData: function() {
      return this.formatData;
    }
  }
};
</script>
<style lang ="less">
.el-col {
  border: 1px solid transparent;
}
</style>