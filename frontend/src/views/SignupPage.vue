<template>
  <div class="backSignup" style="height: 1000px">
    <p class="signUpman">
      <span style="padding-left: 320px; color: cadetblue; font-weight: bold;"> BIENVENUE POUR NEW MEMBER DE</span>
      <span style="padding-left: 30px; font-size: 60px; font-style: italic; font-weight: bolder; color: gray;
                text-decoration: underline indianred">WL</span>
    </p>
  <admin-setup-form v-if="isSignUp" @submit="onSubmit" :isTrueSignUp="isSignUp"></admin-setup-form>
  </div>
</template>

<script>
import axios from 'axios'
import AdminSetupForm from '../components/AdminSetupForm.vue'
import { mapState, mapGetters } from 'vuex'

export default {
  name: 'SignupPage',
  components: {
    AdminSetupForm
  },
  computed: {
    ...mapState(['isTrueSignUp']),
    ...mapGetters(['isSignUp'])
  },
  methods: {
    onSubmit (payload) {
      console.log('payload: ' + payload.userId + ', ' + payload.userName + ', ' + payload.userPw)
      const { userId, userName, userPw, fex, fartist, usere } = payload
      axios.post('http://localhost:24688/users/setup', { userId, userName, userPw, fex, fartist, usere })
        .then(res => {
          alert('성공적으로 가입되었습니다. ')
          this.$router.push({
            name: 'Home'
          })
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  },
  created () {
    console.log('isTrueSignUp: ' + this.isTrueSignUp)
  }
}
</script>

<style>
.signUpman {
  font-bolder: 10px;
  font-size: 32px;
}
.backSignup {
  background: url('../assets/image3.jpeg') center;
  background-size: 1200px;
  background-repeat: no-repeat;
}
</style>
