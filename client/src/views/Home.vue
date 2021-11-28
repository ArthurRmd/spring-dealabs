<template>

  <div class="container">

<!--    {-->
<!--       "id": 2,-->
<!--       "title": "Promo de ouf",-->
<!--       "author": "",-->
<!--       "shopName": "amazon",-->
<!--       "imageUrl": "https://via.placeholder.com/150",-->
<!--       "temperature": -1.0,-->
<!--       "createdAt": "2021-11-10T14:07:40.000+00:00"-->
<!--    },-->

    <div v-for="deal in deals" :key="deal.id">
      <div class="card" @click="dealRedirection(deal.id)">
        <div class="card-content">
          <div class="columns">
            <div class="column is-3">
              <img :src="deal.imageUrl" alt="">
            </div>
            <div class="column has-text-left">
              <h1>Temerature : {{ deal.temperature}}</h1>
              <h1>Title : {{ deal.title}}</h1>
              <h1>Author : {{deal.author}}</h1>
              <h1>Owner : {{ deal.shopName}}</h1>
            </div>
            <div class="column is-2">
              <h1> {{ convertDate(deal.createdAt)}}</h1>
              <button class="button is-info btn-show">Show</button>
            </div>
          </div>

        </div>
      </div>
    </div>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Deals",
  async mounted() {
    const response = await axios.get("http://127.0.0.1:8080/deal")
    this.deals = response.data
  },
  data() {
    return {
      deals : null
    }
  },
  methods : {
    convertDate(date) {
      const dateFormated = new Date(date)
      const dd = String(dateFormated.getDate()).padStart(2, '0');
      const mm = String(dateFormated.getMonth() + 1).padStart(2, '0'); //January is 0!
      const yyyy = dateFormated.getFullYear();
      return mm + '/' + dd + '/' + yyyy;
    },
    dealRedirection(dealId){
      this.$router.push({ name: 'deal', params: { id: dealId } })
    }

  }
}
</script>

<style scoped>
  .card {
    margin: 20px auto;
    max-width: 1000px;
    height: 200px;
  }

  .card:hover{
    background-color: #efefef;
    cursor: pointer;
  }

  .btn-show {
    margin-top: 90px;
    /*margin-left: 200px;*/
  }
</style>