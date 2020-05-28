<template>
  <d2-container>
    <div class="detail">
      <div>
        <img src alt />
        <span class="username">{{userInfo.name}}</span>
        <span class="end-time">截止于 {{workInfo.end_time}}</span>
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
        <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
        <span v-if="workInfo.thumbUp != undefined">{{workInfo.thumbUp}}</span>
        <span v-else>{{workInfo.thumb_up}}</span>
      </p>
      <p>
        <i class="el-icon-star-off"></i>
        <span>{{workInfo.collect}}</span>
      </p>
      <p>
        <i class="fa fa-comment-o itop" aria-hidden="true"></i>
        <span>{{workInfo.comment}}</span>
      </p>
    </div>
    <comment-list :data="commentInfo"></comment-list>
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
      commentInfo: ""
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
        `/api/query/good/comment/table_id/${item.id}`
      );
      // console.log(data);
      this.commentInfo = data.data;
      console.log(this.commentInfo);
      // this.$options.methods.getUserName(this.commentInfo.user_id);
    },
    // async getUserName(user_id) {
    //   const { data } = await axios.get(`/api/user/query/id/${user_id}`);
    //   console.log(data);
    // }
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