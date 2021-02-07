<template>
  <div class="mainhome">
    <p class="title" style="margin-left: 900px;">WeB LABORATOIRE</p><br>
    <div id="login header" v-if="isTrueAuth">
      <v-btn @click="$router.push('Exhibition')" rounded color="lime darken-2 white--text"
             style="margin-left: 1100px; margin-top: 40px;">
        ONLINE EXHIBITION
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn id="gallery" @click="$router.push('BoardGalleryPage')"
             rounded color="white" style="margin-left: 1100px; margin-top: 10px;"> BOARD GALLERY</v-btn>
      <v-spacer></v-spacer>
      <v-btn id="logout" @click="onClickLogout"
             rounded color="white" style="margin-left: 1100px; margin-top: 10px;">
        LOGOUT
      </v-btn>
      <v-spacer></v-spacer>
      <div id="login autho" v-if="isAuthorized">
        <v-btn @click="$router.push('ManagementPage')"
               rounded color="white" style="margin-left: 1100px; margin-top: 10px;">
          MEMBER MANAGEMENT</v-btn>
      </div>
    </div>
    <div id="header" v-else>
    <v-btn @click="$router.push('Exhibition')" rounded color="lime darken-2 white--text"
           style="margin-left: 1100px; margin-top: 40px;">
      ONLINE EXHIBITION
    </v-btn><br>
    <v-btn id="login" @click="$router.push('LoginPage')" rounded color="lime darken-2 white--text"
           style="margin-left: 1100px; margin-top: 10px;"> SIGN IN </v-btn><br>
    <v-btn id="signup" @click="$router.push('SignupPage')" rounded color="lime" style="margin-left: 1100px; margin-top: 10px;">
      SIGN UP
    </v-btn>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  name: 'MainHomeForm',
  methods: {
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'Home' })
    },
    ...mapActions(['logout'])
  },
  // life cycle vuejs.
  computed: {
    ...mapGetters(['isTrueAuth', 'isAuthorized'])
  }
}
</script>

<style>
.title {
  writing-mode: vertical-rl;
  border-radius: 100px 40px 20px 90px;
  background-color: darkgoldenrod;
  padding: 50px 10px;
  font-family: Impact, Charcoal, sans-serif;
  font-size: 32px;
  color: floralwhite;
  font-weight: bolder;
}
.mainhome {
  background: url('../assets/photo2.jpg') left bottom no-repeat;
  height: 720px;
  background-size: 42%;
}
</style>
