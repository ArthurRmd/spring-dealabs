<template>

  <div class="container">

    <div v-for="deal in deals" :key="deal.id">
      <div class="card" @click="dealRedirection(deal.id)">
        <div class="card-content">
          <DealPrincipalData :convert-date="convertDate(deal.createdAt)" :deal="deal"/>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import axios from "axios";
import DealPrincipalData from "../components/DealPrincipalData";

export default {
  name: "Deals",
  components: {DealPrincipalData},
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
    },

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

</style>