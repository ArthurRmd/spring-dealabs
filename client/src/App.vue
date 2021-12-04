<template>
  <div>
    <nav class="navbar is-info" role="navigation" aria-label="main navigation">
      <div class="navbar-brand">
        <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
        </a>
      </div>

      <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
          <router-link class="navbar-item" to="/">Home</router-link>
        </div>

        <div class="navbar-end">
          <div class="navbar-item">
            <div class="buttons">
              <template v-if="user.connected">
                <button  class="button is-light">
                  <strong>User: {{ user.pseudo }}</strong>
                </button>
                <button to="/sign-up" class="button is-light" @click="disconnect">
                  <strong>Disconnect</strong>
                </button>
              </template>
              <template v-else>
                <router-link to="/sign-up" class="button is-light">
                  <strong>Sign up</strong>
                </router-link>
                <router-link to="/login" class="button is-light">
                  Log in
                </router-link>
              </template>

              <button @click="createDeal" class="button is-light">
                Create deal
              </button>
            </div>
          </div>
        </div>
      </div>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>

import Swal from "sweetalert2";

export default {
  name: 'App',
  computed: {
    user() {
      return this.$store.getters.getUser
    }
  },
  methods: {
    disconnect() {
      this.$store.commit('disconnectUser')
    },
    createDeal() {
      if(!this.user.connected) {
        Swal.fire(
            'You are not connected',
            'Please connect with your account',
            'error'
        )
        return;
      }
      this.$router.push({ name: 'create-deal' })

    }
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
  margin-top: 60px;
}
</style>
