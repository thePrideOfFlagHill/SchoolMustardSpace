<template>
  <div>
      <ul>
          <li v-for="(item , index) in data" :key="index">
              <div><span>#{{index+1}}楼</span><span>{{item.publish_time}}</span><span></span></div>
              <p class="content">{{item.content}}</p>
          </li>
      </ul>
  </div>
</template>

<script>
export default {
 name : "comment-list",
    props: {
            data: {
                type: Array,
                default () {
                    return []
                }
            }
        },
    methods:{
        handleClick(item) {
            this.$emit('clickItem',item);
        }
    }
}

</script>

<style  lang ="less" scoped>

li{
    list-style: none;
    border: 1px solid #e6e6e6;
    span{
        margin-left: 20px;
    }
    .content{
        font-size: 15px;
        color: gray;
        margin-left: 20px;
    }

}
.work{
    cursor: pointer;
}
</style>

