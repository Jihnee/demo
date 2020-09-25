<template>
  <div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <table class="baack" style="width: 800px; font-style: oblique">
      <tr style="height: 30px">
        <td align="center" style="font-weight: bolder; font-style: oblique">BOARD NO </td>
        <td><input type="text" :value="boardGallery.boardNo" readonly></td>
      </tr>
      <tr style="height: 30px">
        <td align="center" style="font-weight: bolder; font-style: oblique">REGISTRATION DATE</td>
        <td><input type="text" :value="boardGallery.regDate" readonly></td>
      </tr>
      <tr style="height: 30px">
        <td align="center" style="font-weight: bolder; font-style: oblique">TITLE</td>
        <td><input type="text" :value="boardGallery.title" readonly></td>
      </tr>
      <tr style="height: 30px">
        <td align="center" style="font-weight: bolder; font-style: oblique">WRITER</td>
        <td><input type="text" :value="boardGallery.writer" readonly></td>
      </tr>
      <tr style="height: 400px">
        <td align="center" style="font-weight: bolder; font-style: oblique">CONTENT</td>
        <td><textarea :value="boardGallery.content" rows="5" readonly></textarea></td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'BoardRead',
  props: {
    boardGallery: {
      type: Object,
      required: true
    }
  }
}
</script>

<style>
.baack {
  background-color: #AFB42B;
}
</style>
