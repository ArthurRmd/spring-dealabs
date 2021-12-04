<template>
  <div>
    <div class="container">
      <div class="card">
        <div class="card-content has-text-left">
          <h1 class="is-size-3 mb-6">Sign up</h1>

          <div class="field">
            <label class="label">Pseudo</label>
            <div class="control">
              <input v-model="pseudo" class="input" type="text" placeholder="">
            </div>
          </div>


          <div class="field">
            <label class="label">First name</label>
            <div class="control">
              <input v-model="firstname" class="input" type="text" placeholder="">
            </div>
          </div>


          <div class="field">
            <label class="label">name :</label>
            <div class="control">
              <input v-model="name" class="input" type="text" placeholder="">
            </div>
          </div>

          <div class="field">
            <label class="label">Password</label>
            <div class="control">
              <input v-model="password" class="input" type="password" placeholder="">
            </div>
          </div>

          <div class="field">
            <label class="label">Password confirmation</label>
            <div class="control">
              <input v-model="passwordConfirmation" class="input" type="password" placeholder="">
            </div>
          </div>


          <div class="field is-grouped is-grouped-centered">
            <p class="control">
              <button class="button is-primary" @click="addDeal">
                Create account
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
  name: "SignUp",
  data() {
    return {
      pseudo : "",
      name : "",
      firstname : "",
      password : "",
      passwordConfirmation : "",
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