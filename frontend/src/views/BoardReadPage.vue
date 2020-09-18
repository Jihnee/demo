<template>
  <div align="center">
    <board-read v-if="boardGallery" :boardGallery="boardGallery"/>
    <p v-else> 로딩중입니다 </p>
    <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
       EDIT
    </router-link>
    <button @click="onDelete">DELETE </button>
    <router-link :to="{ name: 'BoardGalleryPage' }">
      List
    </router-link>
  </div>
</template>

<script>
import BoardRead from '@/components/BoardRead'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'BoardReadPage',
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState([
      'boardGallery'
    ])
  },
  created () {
    console.log('BoardReadPage created(): ' + this.boardNo)
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.push()
      })
  },
  methods: {
    ...mapActions([
      'fetchBoard'
    ]),
    onDelete () {
      const { boardNo } = this.boardGallery
      axios.delete(`http://localhost:24688/boards/${boardNo}`)
        .then(res => {
          alert('Delete Success')
          this.$router.push({ name: 'BoardListPage' })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  },
  components: {
    BoardRead
  }
}
</script>
