<template>
  <div>
    <div class="columns">
      <div class="column is-narrow">
        <div style="width: 175px;">
          <p class="title is-6">{{ userName }} ({{ messageDate}})</p>
        </div>
      </div>
      <div class="column">
        <p style="text-align: left">
          {{ messageText }}
        </p>
      </div>
    </div>
    <hr>
  </div>

</template>

<script>
export default {
  name: "UserMessage",
  props: [
      'userName',
      'messageDate',
      'messageText'
  ]
}
</script>

<style scoped>

</style>