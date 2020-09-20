import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import LoginPage from '../views/LoginPage.vue'
import SignupPage from '../views/SignupPage.vue'
import WexhibitionPage from '../views/WexhibitionPage.vue'

import BoardGalleryPage from '../views/BoardGalleryPage.vue'
import BoardRegisterPage from '../views/BoardRegisterPage.vue'
import BoardReadPage from '../views/BoardReadPage.vue'
import BoardModifyPage from '../views/BoardModifyPage.vue'

// Login System

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
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
  },
  {
    path: '/boards/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
