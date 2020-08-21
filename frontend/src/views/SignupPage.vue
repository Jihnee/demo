<template>
  <div align="center">
    <h2>환영합니다 고객님</h2>
    <admin-setup-form @submit="onSubmit"/>
  </div>
</template>

<script>
import axios from 'axios'
import SignupSetupForm from '@/components/SignupSetupForm.vue'

export default {
  name: 'SignupPage',
  components: {
    SignupSetupForm
  },
  methods: {
    onSubmit (payload) {
      console.log('payload: ' + payload.username +
                  ', ' + payload.userid)
      const { username, usernickname, userid, userpw, confirmationpw, fex, fartist } = payload
      axios.post('http://localhost:24688/user/signup', { username, usernickname, userid, userpw, confirmationpw,
      fex, fartist })
      .then(res => {
        alert('가입 성공')
        this.$router.push({
          name: 'Home'
        })
      })
    }
  }
}
</script>
