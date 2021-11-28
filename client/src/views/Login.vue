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

export default {
  name: "Login",
  data() {
    return {
      pseudo: '',
      password: '',
    }
  },
  methods : {
    login(){
      this.$store.commit('setUser', {
            connected: true,
            pseudo: "Adrien",
            firstname: "",
            name: "",
            token: "",
          }
      )
    }
  }
}
</script>

<style scoped>

</style>