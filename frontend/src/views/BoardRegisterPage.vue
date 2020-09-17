<template>
  <div class="bg" align="center">
    <board-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import BoardRegisterForm from '../components/BoardRegisterForm'
import axios from 'axios'

export default {
  name: 'BoardRegisterPage',
  components: {
    BoardRegisterForm
  },
  methods: {
    onSubmit (payload) {
      console.log('BoardRegisterPage onSubmit()')
      const { title, writer, content } = payload
      axios.post('http://localhost:24688/boards', { title, writer, content })
        .then(res => {
          console.log(res)
          alert('Posting Success')
          this.$router.push({
            name: 'BoardGalleryPage',
            params: { boardNo: res.data.boardNo.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}

</script>

<style>
.bg {
   position: fixed;
   left: 7%;
   width: 130%;
   height: 200%;
   background-image: url(../assets/photodd.jpg);
}
</style>
