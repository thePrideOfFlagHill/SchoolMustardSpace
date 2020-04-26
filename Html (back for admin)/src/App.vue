<template>
  <div id="app">
    <Nav></Nav>
    <div id="slide" class="col-xs-2">
      <ul id="slideNav" class="nav">
        <li><router-link to="/overview">概览</router-link></li>
        <hr/>
        <li><router-link to="/manageTask">任务管理</router-link></li>
      </ul>
    </div>
    <div class="col-xs-1"></div>
    <router-view class="col-xs-8" />
  </div>
</template>

<script>
import Nav from '@/components/Nav.vue'

export default {
  name: 'main',
  components: {
    Nav
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
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

#slideNav{
  margin: 0;
  background-color: white;
}

hr{
  -moz-border-bottom-colors: none;
  -moz-border-left-colors: none;
  -moz-border-right-colors: none;
  -moz-border-top-colors: none;
  border-color: #EEEEEE -moz-use-text-color #FFFFFF;
  border-style: solid none;
  border-width: 1px 0;
  margin: 0px 0;
}

</style>
