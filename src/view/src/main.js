import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import Products from './components/Products.vue'
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
    { path: '/', component: Products },
    { path: '/:category', component: Products }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
  })
  

const app = createApp(App)
  app.use(router)
  app.mount('#app')