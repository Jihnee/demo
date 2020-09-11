<template>
  <div>
    <Layout>
    </Layout>
    <LoginForm @submit="onSubmit"></LoginForm>
  </div>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'
import Layout from '@/components/Layout'
import { mapActions, mapGetters, mapState } from 'vuex'

export default {
  name: 'LoginPage',
  components: {
    LoginForm,
    Layout
  },
  methods: {
    onSubmit (payload) {
      console.log('loginPage onSubmit()')
      this.login(payload).then(res => {
        alert('Login Success')
        this.$router.push({ name: 'Home' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('Something Fail: ', err)
      })
    },
    ...mapActions(['login'])
  },
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
  }
}
</script>
