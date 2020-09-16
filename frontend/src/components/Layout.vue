<template>
  <v-app id="layout" style="background-color: #90A4AE">
    <v-app-bar
      app
      color="transparent"
      shrink-on-scroll
      src="https://t1.daumcdn.net/cfile/blog/9922123D5B39985D0E"
      height="250px"
    >
      <v-toolbar-title class="white--text" style="padding-right: 100px">
        WhiteWeb Project
      </v-toolbar-title>
      <v-btn id="home" @click="home"
             text color="white" style="margin-right: 40px">HOME</v-btn>
      <v-btn id="aboutUs" @click="aboutUs" text color="white"
             style="margin-right: 40px">ABOUT US</v-btn>
      <v-btn id="exhibition" @click="wExhibition"
             text color="white" style="margin-right: 40px">WW EXHIBITION</v-btn>
      <v-btn id="information" text color="white"
             style="margin-right: 40px">INFORMATION</v-btn>
      <v-btn id="gallery" @click="boardGallery" text color="white"
             style="margin-right: 40px">BOARD GALLERY</v-btn>
      <div class="home">
        <div id="login header" v-if="isAuthorized">
          <v-btn id="myinfo" @click="$router.push('myinfo')"
                 rounded color="lime darken-2 white--text" style="margin-right: 10px; margin-top: 7px">
            MYINFO
          </v-btn>
          <v-btn id="logout" @click="onClickLogout"
                 rounded color="lime darken-2 white--text" style="margin-right: 10px; margin-top: 7px">
            LOGOUT
          </v-btn>
        </div>
        <div id="header" v-else>
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
      <v-content id="content"
        style="padding: 0px 0px"
        align="center"
      >
        <slot name="content"></slot>
      </v-content>
    </v-container>
  </v-app>
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
    wExhibition () {
      (window.location.pathname !== '/Wexhibition') ? router.push('/Wexhibition') : router.go(0)
    },
    boardGallery () {
      (window.location.pathname !== '/BoardGalleryPage') ? router.push('/BoardGalleryPage') : router.go(0)
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

<style>
.v-app-bar {
  height: 400px;
}

.v-responsive__content {
  width: 10px;
}
</style>
