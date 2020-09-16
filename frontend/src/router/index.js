import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import LoginPage from '../views/LoginPage.vue'
import SignupPage from '../views/SignupPage.vue'
import AboutUs from '../views/AboutUs.vue'
import WexhibitionPage from '../views/WexhibitionPage.vue'
import BoardGalleryPage from '../views/BoardGalleryPage.vue'
import BoardRegisterPage from '../views/BoardRegisterPage.vue'

// Login System

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/AboutUs',
    name: 'AboutUs',
    components: {
      default: AboutUs
    }
  },
  {
    path: '/LoginPage',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/SignupPage',
    name: 'SignupPage',
    components: {
      default: SignupPage
    }
  },
  {
    path: '/WexhibitionPage',
    name: 'WexhibitionPage',
    components: {
      default: WexhibitionPage
    }
  },
  {
    path: '/BoardGalleryPage',
    name: 'BoardGalleryPage',
    components: {
      default: BoardGalleryPage
    }
  },
  {
    path: '/BoardRegisterPage',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
