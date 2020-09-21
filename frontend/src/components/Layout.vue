<template>
  <div>
      <v-btn id="gallery" @click="$router.push('BoardGalleryPage')" text color="white"
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
    wExhibition () {
      (window.location.pathname !== '/Wexhibition') ? router.push('/Wexhibition') : router.go(0)
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
