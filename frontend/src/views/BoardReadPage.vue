<template>
  <div class="dj" align="center" style="height: 1000px">
    <board-read v-if="boardGallery" :boardGallery="boardGallery"/>
    <router-link class="yyy" :to="{ name: 'BoardModifyPage', params: { boardNo } }">
       EDIT
    </router-link>
    <button class="yyy" @click="onDelete">DELETE </button>
    <router-link class="yyy" :to="{ name: 'BoardGalleryPage' }">
      LIST
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
          this.$router.push({ name: 'BoardGalleryPage' })
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

<style>
.dj {
  background: url('../assets/image4.png')
}
.yyy {
  background-color: mediumslateblue;
  border-radius: 100px 40px 70px 10px;
  color: white;
  font-style: oblique;
  padding: 20px;
  font-weight: bolder;
}
</style>
