<template>
  <div>
    <table>
      <tr>
        <td>No.</td>
        <td><input type="text" :value="boardGallery.boardNo" readonly></td>
      </tr>
      <tr>
        <td>Registration Date</td>
        <td><input type="text" :value="boardGallery.regDate" readonly></td>
      </tr>
      <tr>
        <td>Title</td>
        <td><input type="text" :value="boardGallery.title" readonly></td>
      </tr>
      <tr>
        <td>Writer</td>
        <td><input type="text" :value="boardGallery.writer" readonly></td>
      </tr>
      <tr>
        <td>Content</td>
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
