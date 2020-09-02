<template>
  <div>
    <v-app id="layout">
      <v-app-bar
        absolute
        color="#6A76AB"
        dark
        shrink-on-scroll
        height="250px"
        src="https://t1.daumcdn.net/cfile/blog/9922123D5B39985D0E"
        fade-img-on-scroll
        scroll-target="#scrolling-techniques-4"
      >
        <v-toolbar-title class="text--white" style="padding-right: 100px">
          WhiteWeb Project
        </v-toolbar-title>
        <v-btn id="home" @click="home"
               text color="white" style="margin-right: 40px">HOME</v-btn>
        <v-btn id="aboutUs" @click="aboutUs" text color="white"
               style="margin-right: 40px">ABOUT US</v-btn>
        <v-btn id="exhibition" text color="white"
               style="margin-right: 40px">WW EXHIBITION</v-btn>
        <v-btn id="information" text color="white"
               style="margin-right: 40px">INFORMATION</v-btn>
        <v-btn id="gallery" text color="white"
               style="margin-right: 40px">BOARD GALLERY</v-btn>
        <div id="login header">
          <div v-if="isAuthorized">
            {{ myinfo.auth }} 님 환영합니다!
            <v-btn id="myinfo" @click="$router.push('Myinfo')">
              MYINFO
            </v-btn>
            <v-btn id="logout" @click="onClickLogout"
                   rounded color="lime darken-2 white--text" style="margin-top: 7px">LOGOUT</v-btn>
          </div>
          <div v-else>
            <v-btn id="login" @click="$router.push('LoginPage')"
                   rounded color="lime darken-2 white--text" style="margin-right: 10px; margin-top: 7px">
              LOGIN
            </v-btn>
            <v-btn type="login" @click="$router.push('SignupPage')"
                   rounded color="lime darken-2 white--text" style="margin-right: 10px; margin-top: 7px">
              SIGN UP
            </v-btn>
          </div>
        </div>
      </v-app-bar>
      <v-container>
        <v-content id="content">
        </v-content>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import router from '../router'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'Layout',
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    aboutUs () {
      (window.location.pathname !== '/AboutUs') ? router.push('/AboutUs') : router.go(0)
    },
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'Home' })
    },
    ...mapActions(['logout'])
  },
  computed: {
    ...mapGetters(['isAuthorized'])
  }
}
</script>
