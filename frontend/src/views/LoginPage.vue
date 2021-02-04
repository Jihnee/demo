<template>
  <v-parallax src="@/assets/photo3.jpg" style="height: 1000px">
    <p class="jb-default" style="text-align: center; font-weight: bolder; padding-top: 50px"><br>
      <span style="color: #37474F; background-color: #F9FBE7; box-shadow: 0px 100px #9E9D24;
                  font-size: 80px; padding: 10px 100px;
                  text-decoration: line-through #69F0AE">
        Web LABO</span>
    </p>
    <v-spacer></v-spacer>
    <LoginForm @submit="onSubmit" ></LoginForm>
  </v-parallax>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'LoginPage',
  components: {
    LoginForm
  },
  methods: {
    onSubmit (payload) {
      console.log('loginPage onSubmit()')
      this.login(payload).then(res => {
        alert('Login Success')
        this.$router.push({ name: 'Home' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('다시 시도해주세요: ', err)
      })
    },
    ...mapActions(['login'])
  },
  computed: {
    ...mapGetters(['isTrueAuth'])
  }
}
</script>

<style>
  .jb-default {
    font-size: 32px;
    font-style: italic;
  }
</style>
