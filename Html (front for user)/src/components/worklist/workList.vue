<template>
  <div>
    <ul>
      <li v-for="(item,index) in data" :key="index" class="work" @click="handleClick(item)">
        <p class="title">{{item.title}}</p>
        <span class="lable">标签{{item.lable}}</span>
        <p class="content">{{item.content}}</p>
        <p class="start-time">
          发布于
          <span>{{item.start_time}}</span>
        </p>
        <div class="tcc">
          <p>
            <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
            <span v-if="item.thumbUp != undefined">{{item.thumbUp}}</span>
            <span v-else>{{item.thumb_up}}</span>
          </p>
          <p>
            <i class="el-icon-star-off"></i>
            <span>{{item.collect}}</span>
          </p>
          <p>
            <i class="fa fa-comment-o itop" aria-hidden="true"></i>
            <span>{{item.comment}}</span>
          </p>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import {formatDataWork} from '../../assets/js/index';
export default {
  name: "work-list",
  props: {
    data: {
      type: Array,
      default() {
        return [];
      }
    }
  },
  methods: {
    handleClick(item) {
      this.$emit("clickItem", item);
    }
    
  },
};
</script>

<style  lang ="less" scoped>
li {
  list-style: none;
  .title {
    font-size: 15px;
  }
  .lable {
    border: 1px solid #e6e6e6;
    padding: 5px 10px;
    font-size: 10px;
  }
  .content {
    margin-top: 15px;
    font-size: 10px;
    color: gray;
    height: 30px;
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
  .start-time {
    font-size: 13px;
    span {
      color: skyblue;
    }
  }
  border-bottom: 1px solid #e6e6e6;
}
.work {
  cursor: pointer;
}
</style>