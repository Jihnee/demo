<template>
  <div class="mainhome">
    <p class="title" style="margin-left: 900px;">WeB lAbO FOR ☞ Jihnee ☜ </p><br>
    <v-btn id="exhibition" @click="$router.push('Wexhibition')" rounded color="lime darken-2 white--text"
           style="margin-left: 1100px; margin-top: 40px;">
      ONLINE EXHIBITION
    </v-btn><br>
    <v-btn id="login" @click="$router.push('LoginPage')" rounded color="lime darken-2 white--text"
           style="margin-left: 1100px; margin-top: 10px;"> LOGIN </v-btn><br>
    <v-btn id="signup" @click="$router.push('SignupPage')" rounded color="lime" style="margin-left: 1100px; margin-top: 10px;">
      SIGN IN
    </v-btn>
  </div>
</template>

<script>
export default {
  name: 'MainHomeForm'
}
</script>

<style>
.title {
  writing-mode: vertical-rl;
  background-color: white;
  padding: 50px 10px;
  font-family: Impact, Charcoal, sans-serif;
  font-size: 32px;
  color: #00b0ff;
}
.mainhome {
  background: url('../assets/photo2.jpg') left bottom no-repeat;
  height: 720px;
  background-size: 42%;
}
</style>
