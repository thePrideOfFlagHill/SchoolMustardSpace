<template>
  <d2-container>
    <template slot="header">
      <el-row :gutter="20">
        <el-col :span="8">搜索物品</el-col>
        <el-col :span="6" class="d2-text-center"></el-col>
        <el-col :span="6" style="cursor:pointer;margin-top:0px"></el-col>
        <el-col :span="2" class="d2-text-center" style="cursor:pointer;">
          <el-button @click="goToInsert">我要发布</el-button>
        </el-col>
        <el-col :span="2" class="d2-text-center" style="cursor:pointer;">
          <el-button @click="goToMy">我的任务</el-button>
        </el-col>
      </el-row>
    </template>
    <work-list :data="formatData" class="work-list" @clickItem="goToWorkDetail"></work-list>
  </d2-container>
</template>

<script>
import WorkList from "@/components/worklist/workList";
import { GetWorkList } from "@/api/work/work";
import { formatDataWork } from "@/assets/js/index";
import axios from "axios";
export default {
  name: "page7",
  data() {
    return {
      input: "",
      userid: "",
      input: "",
      formatData: ""
    };
  },
  computed: {
    user: function() {
      return this.$store.state.d2admin.user.info.name;
    }
  },
  components: {
    WorkList
  },
  methods: {
    async getWorkLits() {
      const { data } = await axios.get(
        "/api/lost_and_found/query/userId?userId=" + this.$store.state.userid
      );
      // console.log(data);
      if (data.status == 200) this.formatData = data.data;
      this.formatData = formatDataWork(this.formatData);

      console.log(this.formatData);
    },
    goToWorkDetail(item) {
      this.$router.push({
        name: "page8",
        params: {
          data: item
        }
      });
    },
    goToInsert() {
      this.$router.push({ name: "page6" });
    },
    goToMy() {
      this.$router.push({ name: "page7" });
    }
  },
  created() {
    this.getWorkLits();
  }
};
</script>
<style>
.el-col {
  border: 1px solid transparent;
}
</style>