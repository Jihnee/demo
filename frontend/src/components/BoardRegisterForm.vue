<template>
  <form @submit.prevent="onSubmit">
    <p class="body-default"><br><br>
      <span>※『 ㉠ㅔ㉦ㅣ㉺㉡ 』※</span>
    </p>
      <table class="tr" border="5" bordercolor="yellow" style="center">
        <tr>
          <td>Title</td>
          <td><input type="text" v-model="title"></td>
        </tr>
        <tr>
          <td>Writer</td>
          <td><input type="text" v-model="writer"></td>
        </tr>
        <tr>
          <td>Content</td>
          <td><textarea v-model="content" rows="5"></textarea></td>
        </tr>
      </table>
      <div>
        <button type="submit">Register</button>
        <router-link :to="{ name: 'BoardGalleryPage' }">
          Cancel
        </router-link>
      </div>
    </form>
</template>

<script>
export default {
  name: 'BoardRegisterForm',
  data () {
    return {
      title: '',
      writer: '',
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>
