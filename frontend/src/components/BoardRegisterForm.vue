<template>
  <form @submit.prevent="onSubmit">
    <p class="body-default"><br><br>
      <span>※『 ㉠ㅔ㉦ㅣ㉺㉡ 』※</span>
    </p><br>
      <table class="tr" border="5" style="center">
        <tr>
          <td align="center" width="80">Title</td>
          <td width="500"><input type="text" v-model="title"></td>
        </tr>
        <tr>
          <td align="center" width="80">Writer</td>
          <td><input type="text" v-model="writer" height="20"></td>
        </tr>
        <tr>
          <td align="center" width="80">Content</td>
          <td><textarea v-model="content" cols="50" rows="20"></textarea></td>
        </tr>
      </table>
      <div>
        <button type="submit">Register</button>
        <router-link :to="{ name: 'BoardReadPage' }">
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

<style>
.tr {
  border-color: #37474F;
  border-width: 30px;
}
.body-default{
  color: #37474F;
}
</style>
