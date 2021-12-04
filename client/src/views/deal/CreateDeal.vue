<template>
  <div>
    <div class="container">
      <div class="card">
        <div class="card-content has-text-left">
          <h1 class="is-size-3 mb-6">Create new Deal</h1>

          <div class="field">
            <label class="label">Title :</label>
            <div class="control">
              <input v-model="title" class="input" type="text" placeholder="">
            </div>
          </div>


          <div class="field">
            <label class="label">Description : </label>
            <div class="control">
              <textarea v-model="description" class="textarea" placeholder=""></textarea>
            </div>
          </div>


          <div class="field">
            <label class="label">Old price :</label>
            <div class="control">
              <input v-model="oldPrice" class="input" type="number" placeholder="">
            </div>
          </div>


          <div class="field">
            <label class="label">New price :</label>
            <div class="control">
              <input v-model="newPrice" class="input" type="number" placeholder="">
            </div>
          </div>


          <div class="field">
            <label class="label">Owner :</label>
            <div class="control">
              <input v-model="owner" class="input" type="text" placeholder="">
            </div>
          </div>


          <div class="field">
            <label class="label">Promo code :</label>
            <div class="control">
              <input v-model="promoCode" class="input" type="text" placeholder="">
            </div>
          </div>


          <div class="field">
            <label class="label">Image link :</label>
            <div class="control">
              <input v-model="imageLink" class="input" type="text" placeholder="">
            </div>
          </div>

          <div class="field">
            <label class="label">Shop link :</label>
            <div class="control">
              <input v-model="shopLink" class="input" type="text" placeholder="">
            </div>
          </div>

          <div class="field is-grouped is-grouped-centered">
            <p class="control">
              <button class="button is-primary" @click="addDeal">
                Submit
              </button>
            </p>
            <p class="control">
              <a class="button is-light">
                Cancel
              </a>
            </p>
          </div>

        </div>
      </div>
    </div>
  </div>

</template>

<script>
import axios from "axios";

export default {
  name: "CreateDeal",
  data() {
    return {
      title: '',
      description: '',
      oldPrice: '',
      newPrice: '',
      owner: '',
      promoCode: '',
      imageLink: '',
      shopLink: '',
    }
  },
  methods : {
    addDeal(){
      axios.post("http://127.0.0.1:8080/deal/", {
        "title":"test",
        "temperature":15.0,
        "author":"Arthur",
        "shopName":"shop",
        "shopLink":"shopLink",
        "imageUrl":"imgUrl",
        "promoCode":"promoCode",
        "description":"description",
        "oldPrice":15.0,
        "newPrice":15.0,
        "createdAt":"2021-10-12T15:14:29.000+00:00",
      })
    }
  }
}
</script>

<style scoped>

</style>