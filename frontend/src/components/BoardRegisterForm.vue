<template>
  <form @submit.prevent="onSubmit">
    <p class="body-default"><br><br>
      <span></span>
    </p><br>
      <table class="tr" style="background-color: #7986CB">
        <tr>
          <td align="center" width="80" height="50" style="font-style: oblique">TITLE</td>
          <td width="500"><input type="text" v-model="title"></td>
        </tr>
        <tr>
          <td align="center" width="80" style="font-style: oblique">WRITER</td>
          <td><input type="text" v-model="writer" height="20"></td>
        </tr>
        <tr>
          <td align="center" width="100" style="font-style: oblique">CONTENT</td>
          <td><textarea v-model="content" cols="50" rows="20"></textarea></td>
        </tr>
      </table>
      <div>
        <br><button type="submit" style="background-color: #CE93D8; padding: 30px; font-weight: bolder;
                                          font-style: oblique; border-radius: 20px 20px 20px 20px; color: white">REGISTER</button><br><br>
        <button @click="$router.push('BoardGalleryPage')" style="background-color: #F50057; padding: 31px;
                                      font-weight: bolder; font-style: oblique; border-radius: 20px 20px 20px 20px; color: white">CANCEL</button>
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
  border-width: 40px;
}
.body-default{
  color: #37474F;
}
</style>
