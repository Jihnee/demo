<template>
  <Layout>
    <template #menubar>
      <v-btn @click="start('Home')" text color="blue-gry lighten-5"
        style="padding: 10px; width: 90px;">Home</v-btn>
      <v-btn @click="start('Home')" text color="blue-gry lighten-5"
        style="padding: 10px; width: 90px;">About WW</v-btn>
      <v-btn @click="start('Home')" text color="blue-gry lighten-5"
        style="padding: 10px; width: 90px;">WW exhibition</v-btn>
      <v-btn @click="start('Home')" text color="blue-gry lighten-5"
       style="padding: 10px; width: 90px;">Open Diary</v-btn>
      <v-btn @click="start('Home')" text color="blue-gry lighten-5"
       style="padding: 10px; width: 90px;">Open Documentary</v-btn>
    </template>
  </Layout>
</template>

import Layout from '../components/Layout'
import { mapState } from 'vuex'

export default {
  components: { Layout }
    }
}
