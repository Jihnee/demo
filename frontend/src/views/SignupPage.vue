<template>
  <div class="backSignup" style="height: 1000px">
    <p class="signUpman">
      <span style="padding-left: 320px; color: cadetblue; font-weight: bold;"> BIENVENUE POUR NEW MEMBER DE</span>
      <span style="padding-left: 30px; font-size: 60px; font-style: italic; font-weight: bolder; color: gray;
                text-decoration: underline indianred">WL</span>
    </p>
  <admin-setup-form @submit="onSubmit"></admin-setup-form>
  </div>
</template>

<script>
import axios from 'axios'
import AdminSetupForm from '../components/AdminSetupForm.vue'

export default {
  name: 'SignupPage',
  components: {
    AdminSetupForm
  },
  methods: {
    onSubmit (payload) {
      console.log('payload: ' + payload.userId + ', ' + payload.userName + ', ' + payload.userPw)
      // payload 에 회원정보를 담아서 전달
      const { userId, userName, userPw, fex, fartist, userE } = payload
      axios.post('http://localhost:24688/users/signup', { userId, userName, userPw, fex, fartist, userE })
        .then(res => {
          if (res.data) {
            alert('회원가입이 성공했습니다.')
            this.$router.push({
              name: 'Home'
            })
          } else {
            alert('가입 실패')
            this.$router.push({
              name: 'SignupPage'
            })
          }
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
