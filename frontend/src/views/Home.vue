<template>
  <div class="hello">
    <Layout>
    </Layout>
  </div>
</template>

<script>
// import axios from 'axios'
import Layout from '../components/Layout'
// import { mapGetters } from 'vuex'
// import { mapState } from 'vuex'

export default {
  name: 'Home',
  data: function () {
    return {
    }
  },
  components: { Layout }
}
</script>

<style>
.hello {
   position: fixed;
   left: 7%;
   width: 130%;
   height: 200%;
   background-image: url('../assets/photo2.jpg');
}
</style>
