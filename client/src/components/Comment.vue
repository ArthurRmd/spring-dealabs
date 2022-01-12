<template>
  <div class="card">
    <article class="media p-4">
      <div class="media-content">
        <div class="field">
          <p class="control">
            <textarea v-model="message" class="textarea" placeholder="Add a comment..."></textarea>
          </p>
        </div>
        <nav class="level">
          <div class="level-left"></div>
          <div class="level-right">
            <div class="level-item">
              <a class="button is-info" @click="submitComment">Post comment</a>
            </div>
          </div>
        </nav>
      </div>
    </article>
  </div>
</template>

<script>
import Swal from "sweetalert2";

export default {
  name: "Comment",
  computed: {
    user() {
      return this.$store.getters.getUser
    }
  },
  props: {
    'onSubmit': {type: Function}
  },
  data() {
    return {
      'message': '',
    }
  },
  methods : {
    submitComment(){
      if(!this.user.connected) {
        Swal.fire(
            'You are not connected',
            'Please connect with your account',
            'error'
        )
        return;
      }
      this.onSubmit(this.message)
    }
  }
}
</script>

<style scoped>

</style>