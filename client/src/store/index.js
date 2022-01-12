import {createStore} from "vuex";



const store = createStore({
    state () {
        return {
            user : {
                connected: false,
                pseudo: "Arthur",
                firstname: "",
                name: "",
                token: "",
            }
        }
    },
    getters : {
      getUser(state){
          return state.user
      }
    },
    mutations: {
        setUser (state, user) {
            state.user = user
        },
        disconnectUser (state) {
            state.user = {
                connected: false,
                pseudo: "",
                firstname: "",
                name: "",
                token: "",
            }

        }
    }
})
export default store;