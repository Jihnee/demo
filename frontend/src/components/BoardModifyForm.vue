<template>
  <div>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>No </td>
          <td><input type="text" :value="boardGallery.boardNo" disabled></td>
        </tr>
        <tr>
          <td>Registration Date </td>
          <td><input type="text" :value="boardGallery.regDate" disabled></td>
        </tr>
        <tr>
          <td>Title</td>
          <td><input type="text" :value="boardGallery.title" disabled></td>
        </tr>
        <tr>
          <td>Writer</td>
          <td><input type="text" :value="boardGallery.writer" disabled></td>
        </tr>
        <tr>
          <td>Content</td>
          <td><textarea v-model="content" rows="5"></textarea></td>
        </tr>
      </table>

      <div>
        <button type="submit">Edit</button>
        <router-link :to="{ name: 'BoardReadPage', params: { boardNo: boardGallery.boardNo.toString() } }">
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
