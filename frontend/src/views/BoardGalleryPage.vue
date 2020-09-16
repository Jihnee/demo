<template>
  <div id="board">
    <layout>
    </layout>
      <router-link :to="{ name: 'BoardGalleryPage' }">
        Create New Board
      </router-link>
      <board-list :boards="boards"/>
  </div>
</template>

<script>
import Layout from '../components/Layout'
import BoardList from '../components/BoardList'

import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardGalleryPage',
  components: {
    Layout,
    BoardList
  },
  computed: {
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}

</script>
