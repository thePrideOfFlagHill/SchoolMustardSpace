<template>
  <div class="test_box">
    <p @click="go">测试组件内部守卫的作用，点击跳到HelloWorld</p>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
  methods: {
    go() {
      this.$router.push({ name: "HelloWorld" });
    }
  },
  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.$router.replace(from.path);
    });
  },
  beforeRouteUpdate(to, from, next) {
    //在当前路由改变，但是该组件被复用时调用
    //对于一个带有动态参数的路径 /good/:id，在 /good/1 和 /good/2 之间跳转的时候，
    // 由于会渲染同样的good组件，因此组件实例会被复用。而这个钩子就会在这个情况下被调用。
    // 可以访问组件实例 `this`
    console.log(this, "beforeRouteUpdate"); //当前组件实例
    console.log(to, "组件独享守卫beforeRouteUpdate第一个参数");
    console.log(from, "组件独享守beforeRouteUpdate卫第二个参数");
    console.log(next, "组件独享守beforeRouteUpdate卫第三个参数");
    next();
  },
  beforeRouteLeave(to, from, next) {
    // 导航离开该组件的对应路由时调用
    // 可以访问组件实例 `this`
    console.log(this, "beforeRouteLeave"); //当前组件实例
    console.log(to, "组件独享守卫beforeRouteLeave第一个参数");
    console.log(from, "组件独享守卫beforeRouteLeave第二个参数");
    console.log(next, "组件独享守卫beforeRouteLeave第三个参数");
    next();
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>