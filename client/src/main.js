import { createApp } from 'vue'
import App from "./App";
import router from './router'
import store from "./store";
import axios from "axios";


axios.interceptors.request.use(async function (config) {
    if(!config.url.includes('public')) {
        config.headers['Authorization'] = 'Basic' + localStorage.getItem('auth');
    }
    return config
}, function(error){
    return Promise.reject(error)
});

createApp(App).use(router).use(store).mount('#app')
