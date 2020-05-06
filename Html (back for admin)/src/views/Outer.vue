<template>
  <el-container id="outer">
    <el-header>
      <Nav></Nav>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <slideNav></slideNav>
      </el-aside>
      <el-main style="padding-left:0;padding-top:0; min-width:1400px;">
        <el-container>
          <el-header class="bread">
            <crumb></crumb>
          </el-header>
          <el-main>
              <router-view />
          </el-main>
        </el-container>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Nav from '../components/Nav.vue'
import crumb from '../components/crumb.vue'

export default {
  name: 'outer',
  components: {
    Nav,
    crumb,
    slideNav: () => import('../components/slideNav.vue')
  },
  mounted: function () {
    if (this.$store.state.accountNumber === null) {
      this.$router.push({
        name: 'login'
      })
    }
  }
}
</script>

<style>
.el-header {
  padding: 0 !important;
}
.bread {
  margin: 0;
}
#outer {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
}

#slide {
  margin: 0;
  padding: 0;
}

#slide a {
  font-weight: bold;
  color: #2c3e50;
}

#slide a.router-link-exact-active {
  color: #42b983;
}

#slideNav {
  margin: 0;
  background-color: white;
}

hr {
  -moz-border-bottom-colors: none;
  -moz-border-left-colors: none;
  -moz-border-right-colors: none;
  -moz-border-top-colors: none;
  border-color: #eeeeee -moz-use-text-color #ffffff;
  border-style: solid none;
  border-width: 1px 0;
  margin: 0px 0;
}
</style>
