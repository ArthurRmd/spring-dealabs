<template>
  <div>
    <div class="container">
      <div class="card">
        <div class="card-content has-text-left">
          <h1 class="is-size-3 mb-6">Login</h1>

          <div class="field">
            <label class="label">Pseudo :</label>
            <div class="control">
              <input v-model="pseudo" class="input" type="text" placeholder="">
            </div>
          </div>

          <div class="field">
            <label class="label">Password : </label>
            <div class="control">
              <input v-model="password" class="input" type="text" placeholder="">
            </div>
          </div>


          <div class="field is-grouped is-grouped-centered">
            <p class="control">
              <button class="button is-primary" @click="login">
                Login
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
  name: "Login",
  data() {
    return {
      pseudo: '',
      password: '',
    }
  },
  methods: {
    login() {

      const LoginRequestDTO = {
        'pseudo': this.pseudo,
        'password': this.password
      }

      console.log(LoginRequestDTO)

      axios.post('http://127.0.0.1:8080/public/login', LoginRequestDTO)
          .then(
              response => {
                localStorage.setItem('auth', btoa(LoginRequestDTO.pseudo) + ':' + LoginRequestDTO.password)
                this.success(response)
                console.log(response);
              }, error => {btoa
                this.failed(error)
              }
          )



      this.$store.commit('setUser', {
            connected: true,
            pseudo: "Adrien",
            firstname: "",
            name: "",
            token: "",
          }
      )
      //this.$router.push({name: 'home'})

    }
  }
}
</script>

<style scoped>

</style>