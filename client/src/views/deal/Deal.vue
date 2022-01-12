<template>

  <div>
    <div class="container" v-if="deal != null">
      <div class="card card-center">
        <div class="card-content">
          <DealPrincipalData :convert-date="convertDate(deal.createdAt)" :deal="deal"/>
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

      <div class="card comments">
        <div v-for="comment in comments" :key="comment.id">
          <UserMessage :user-name="comment.name"
                       :message-date="comment.date"
                       :message-text="comment.message">
          </UserMessage>
        </div>
      </div>

      <Comment :on-submit="addComment"></Comment>
    </div>


  </div>
</template>

<script>
import axios from "axios";
import UserMessage from "../../components/UserMessage";
import Comment from "../../components/Comment";
import DealPrincipalData from "../../components/DealPrincipalData";
import {convertDateToFrenchFormat} from "../../utils/dateConversion";
import {getRandomComment} from "../../utils/randomFunction";

export default {
  name: "Deal",
  props: ['id'],
  components: {
    UserMessage,
    Comment,
    DealPrincipalData,
  },
  async mounted() {
    const response = await axios.get("http://127.0.0.1:8080/deal/1")
    this.deal = response.data
  },
  data() {
    return {
      deal: null,
      comments: getRandomComment(4),
    }
  },
  methods: {
    convertDate(date) {
      return convertDateToFrenchFormat(date)
    },
    addComment(message) {
      console.log("comment submit => " + message)
    }
  }


}
</script>

<style scoped>
.card-margin {
  margin: 30px auto;
}

.card {
  max-width: 1000px;
  margin: 30px;
  padding: 30px;
}

.btn-show {
  margin-top: 90px;
}

.comments {
  overflow-x: auto;
  height: 400px;
}
</style>