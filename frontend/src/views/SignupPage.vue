<template>
  <div>
    <Layout>
      <template #content>
        <body>
          <p class="signUpman">
            <br<br><span > 【 ㈍ㅗl 우┫㉡ㄱr  @┃㉥ 】</span>
          </p>
        </body>
        <admin-setup-form v-if="isSignUp" @submit="onSubmit" :isTrueSignUp="isSignUp"></admin-setup-form>
      </template>
    </Layout>
  </div>
</template>

<script>
import axios from 'axios'
import Layout from '../components/Layout.vue'
import AdminSetupForm from '../components/AdminSetupForm.vue'
import { mapState, mapGetters } from 'vuex'

export default {
  name: 'SignupPage',
  components: {
    AdminSetupForm,
    Layout
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
</style>
