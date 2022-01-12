<template>
  <div class="columns">
    <div class="column is-3">
      <img :src="deal.imageUrl" alt="">
    </div>
    <div class="column has-text-left">
      <h1>Temerature : {{ deal.temperature}}</h1>
      <h1>Title : {{ deal.title}}</h1>
      <h1>Author : {{deal.author}}</h1>
      <h1>Owner : {{ deal.shopName}}</h1>
      <div v-if="user.connected">
        <button class="button is-small mr-2 mt-2" @click="removeTemperature" >-1</button>
        <button class="button is-small  mt-2" @click="addTemperature" >+1</button>
      </div>
    </div>
    <div class="column is-2">
      <h1> {{ convertDate}}</h1>
      <button class="button is-info btn-show">Show</button>
    </div>
  </div>
</template>
<script>
export default {
  name: 'DealPrincipalData',
  computed: {
    user() {
      return this.$store.getters.getUser
    }
  },
  props: {
    convertDate: {},
    deal: {}
  },
  methods : {
    addTemperature(){
      console.log("add Temperature")
    },
    removeTemperature(){
      console.log("remove Temperature")
    }
  }
}
</script>
<style scoped>

.btn-show {
  margin-top: 90px;
  /*margin-left: 200px;*/
}
</style>