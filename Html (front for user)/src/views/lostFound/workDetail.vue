<template>
  <d2-container>
    <div class="detail">
      <div>
        <img src alt />
        <span class="username">{{userInfo.name}}</span>
        <!-- <span class="end-time">截止于 {{workInfo.end_time}}</span> -->
      </div>
      <!-- <span class="lable">其他</span> -->
      <div class="title">{{workInfo.title}}</div>
      <p class="content">{{workInfo.content}}</p>
      <img class="img" v-lazy="`${workInfo.image}?param=200y200`" alt />
      <div style="height:20px">
        <span class="start-time d2-fr">发布于{{workInfo.start_time}}</span>
      </div>
    </div>
    <div class="tcc">
      <p>
        <a>
          <i class="fa fa-thumbs-o-up" aria-hidden="true" @click="up"></i>
        </a>
        <span>{{workInfo.thumb_up}}</span>
      </p>
      <p>
        <a @click="star">
          <i class="el-icon-star-off"></i>
        </a>
        <span>{{workInfo.collect}}</span>
      </p>
      <p>
        <i class="fa fa-comment-o itop" aria-hidden="true"></i>
        <span>{{numCom}}</span>
      </p>
    </div>
    <comment-list :data="commentInfo"></comment-list>
    <div>
      <div style="margin-top: 15px;">
        <el-input placeholder="请输入内容" v-model="input"></el-input>
        <el-button @click="send">发送</el-button>
      </div>
    </div>
  </d2-container>
</template>

<script>
import axios from "axios";
import CommentList from "@/components/commentList/commentList";
export default {
  name: "page1",
  data() {
    return {
      workInfo: "",
      userInfo: "",
      commentInfo: "",
      input: "",
      numCom: ""
    };
  },
  components: {
    CommentList
  },
  methods: {
    async getinfo(item) {
      // console.log(item);
      this.workInfo = item;
      const { data } = await axios.get(`/api/user/query/id/${item.user_id}`);
      this.userInfo = data.data;
      // console.log(this.userInfo);
    },
    async getCommentInfo(item) {
      const { data } = await axios.get(
        `/api/query/lostfound/comment/table_id/${item.id}`
      );
      // console.log(data);
      this.commentInfo = data.data;
      this.$options.methods.getUserName(this.commentInfo.user_id);
      this.numCom = this.commentInfo.length;
    },
    async getUserName(user_id) {
      const { data } = await axios.get(`/api/user/query/id/${user_id}`);
      console.log(data);
    },

    up() {
      axios
        .get("/api/lost_and_found/update/thumbUp?id=" + this.workInfo.id)
        .then(function(res) {});
    },
    send() {
      var that = this;
      axios
        .post("/api/lostfound/comment/insert", {
          id: "1",
          user_id: that.userInfo.id,
          content: that.input,
          publish_time: "2020/05-30",
          table_id: that.workInfo.id,
          thumb_up: 0,
          comment: 0
        })
        .then(function(res) {
          console.log(res.data);
        });
    },
    star() {
      axios
        .get("/api/lost_and_found/update/collect?id=" + this.workInfo.id)
        .then(function(res) {});
    }
  },
  created() {
    this.getinfo(this.$route.params.data);
    this.getCommentInfo(this.$route.params.data);
  }
};
</script>
<style lang = "less" scoped>
.detail {
  border: 2px solid #e6e6e6;
  height: auto;
  .username {
    font-size: 20px;
  }
  .end-time {
    font-size: 15px;
    color: gray;
    margin-left: 20px;
  }
  .lable {
    border: 1px solid #e6e6e6;
    font-size: 15px;
    padding: 2px 4px;
    margin-top: 10px;
    display: inline-block;
  }
  .title {
    font-size: 30px;
  }
  .content {
    color: #656565;
  }
  .img {
    /* width: 300px; */
    display: block;
    height: 300px;
  }
  .start-time {
    /* border: 1px solid red; */
    font-size: 15px;
    color: gray;
    /* position: absolute; */
    /* left: 80%; */
  }
}
.tcc {
  margin-top: -10px;
  p {
    padding: 0;
    display: inline-block;
    margin-right: 20px;
  }
  span {
    margin-left: 5px;
    color: black;
  }
  flex-direction: row;
}
.itop {
  display: inline-block;
  margin-bottom: 5px;
}
</style>