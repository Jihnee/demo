<template>
  <div class="home">
    <div id="header">
    <router-link :to="{ name: 'Home' }"
        class="nav-link"
        active-class="active">
      Home
    </router-link>
    <router-link :to="{ name: 'About' }"
        class="nav-link"
        active-class="active">
      About Us
    </router-link>
    </div>
    <div id="header">
      <button id="login" @click="$router.push('SignupPage')">
        Sign up
      </button>
    </div>
  </div>
</template>

<style scoped>
div {
  border: 1px solid #ccc;
}

#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
}

img {
  width: auto;
  height: auto;
  max-width: 1000px;
  max-height: 350px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

#login {
  background-color: #F48FB1;
  color: #ffffff;
  font-weight: bold;
  float: right;
}

</style>
