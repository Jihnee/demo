<template>
  <div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <form @submit.prevent="onSubmit">
      <table class="baack" style="width: 800px; font-style: oblique">
        <tr style="height: 30px">
          <td align="center" style="font-weight: bolder; font-style: oblique">BOARD NO </td>
          <td><input type="text" :value="boardGallery.boardNo" disabled></td>
        </tr>
        <tr style="height: 30px">
          <td align="center" style="font-weight: bolder; font-style: oblique">REGISTRATION DATE</td>
          <td><input type="text" :value="boardGallery.regDate" disabled></td>
        </tr>
        <tr style="height: 30px">
          <td align="center" style="font-weight: bolder; font-style: oblique">TITLE</td>
          <td><input type="text" :value="boardGallery.title"></td>
        </tr>
        <tr style="height: 30px">
          <td align="center" style="font-weight: bolder; font-style: oblique">WRITER</td>
          <td><input type="text" :value="boardGallery.writer" disabled></td>
        </tr>
        <tr style="height: 400px">
          <td align="center" style="font-weight: bolder; font-style: oblique">CONTENT</td>
          <td><textarea v-model="content" cols="50" rows="20"></textarea></td>
        </tr>
      </table>

      <div>
        <button type="submit" class="yyy">Edit</button>
        <router-link class="yyy" :to="{ name: 'BoardReadPage', params: { boardNo: boardGallery.boardNo.toString() } }">
         Cancel
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'BoardModifyForm',
  props: {
    boardGallery: {
      type: Object,
      required: true
    }
  },
  methods: {
    onSubmit () {
      const { title, content } = this
      this.$emit('submit', { title, content })
    }
  },
  created () {
    this.title = this.boardGallery.title
    this.content = this.boardGallery.content
  }
}
</script>
