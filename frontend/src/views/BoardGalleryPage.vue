<template>
  <div class="board" style="height: 2000px">
    <p class="body-default"><br>
      <span style="font-weight: bolder; padding-left: 60px; font-size: 50px">BOARD GALLERY</span>
    </p>
    <br><board-list/>
    <button @click="$router.push('BoardRegisterPage')" style="font-weight: bolder; font-size: 20px; color: gray">
      CREATE NEW BOARD
    </button>
  </div>
</template>

<script>
import BoardList from '../components/BoardList'

import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardGalleryPage',
  components: {
    BoardList
  },
  computed: {
    ...mapState(['boards'])
  },
  created () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}

</script>

<style>
.body-default {
    color: yellow;
    font-size: 32px;
}
.board {
  background: url('../assets/photo4.jpg') no-repeat right;
  background-size: 1200px;
}
</style>
