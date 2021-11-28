<template>

  <div>
    <div class="container" v-if="deal != null">
      <div class="card">
        <div class="card-content">
          <div class="columns">
            <div class="column is-3">
              <img :src="deal.imageUrl" alt="">
            </div>
            <div class="column has-text-left">
              <h1>Temerature : {{ deal.temperature }}</h1>
              <h1>Title : {{ deal.title }}</h1>
              <h1>Author : {{ deal.author }}</h1>
              <h1>Owner : {{ deal.shopName }}</h1>
            </div>
            <div class="column is-2">
              <h1> {{ convertDate(deal.createdAt) }}</h1>
              <button class="button is-info btn-show">Show</button>
            </div>
          </div>
          <hr>
          <h1> Promo Code : "{{ deal.promoCode }}"</h1>
          <hr>
          <h1>Price before : {{ deal.oldPrice }}$ | Price now : {{ deal.newPrice }}$</h1>
          <hr>
          <p>
            {{ deal.description }}
          </p>
        </div>
      </div>

    </div>
  </div>

</template>

<script>
import axios from "axios";

export default {
  name: "Deal",
  props: ['id'],
  async mounted() {
    const response = await axios.get("http://127.0.0.1:8080/deal/1")
    this.deal = response.data
    console.log(this.deal)
  },
  data() {
    return {
      deal: null
    }
  },
  methods: {
    convertDate(date) {
      const dateFormated = new Date(date)
      const dd = String(dateFormated.getDate()).padStart(2, '0');
      const mm = String(dateFormated.getMonth() + 1).padStart(2, '0'); //January is 0!
      const yyyy = dateFormated.getFullYear();
      return mm + '/' + dd + '/' + yyyy;
    }
  }


}
</script>

<style scoped>
.card {
  margin: 30px auto;
  max-width: 1000px;
}

.btn-show {
  margin-top: 90px;
  /*margin-left: 200px;*/
}
</style>