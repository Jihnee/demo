<template>
  <div>
    <Layout>
      <template #content>
      </template>
    </Layout>
    <v-carousel :show-arrows="false">
      <v-carousel-item
        v-for="(item,i) in items"
        :key="i"
        :src="item.src"
      ></v-carousel-item>
    </v-carousel>
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
      items: [
        {
          src: 'https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg'
        },
        {
          src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg'
        },
        {
          src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg'
        }
      ]
    }
  },
  components: { Layout }
}
</script>
