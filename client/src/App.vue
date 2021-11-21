<template>
  <nav>
    <router-link to="/">Home</router-link>
    <br>
    <router-link :to="{name:'deal', params : {id: 5}}">Deal</router-link>
  </nav>
  <router-view></router-view>
</template>

<script>
// import HelloWorld from './../components/HelloWorld.vue'

export default {
  name: 'App',
  // components: {
  //   HelloWorld
  // }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
