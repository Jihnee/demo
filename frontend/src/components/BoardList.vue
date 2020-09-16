<template>
  <div>
    <table border="1">
      <tr>
        <th align="center" width="80">No.</th>
        <th align="center" width="320">Title</th>
        <th align="center" width="100">Writer</th>
        <th align="center" width="180">Registration Date</th>
      </tr>

      <tr v-for="boardGallery in boards" :key="boardGallery.boardNo">
        <td align="center">{{ boardGallery.boardNo }}</td>
        <td align="left">
          <router-link :to="{ name: 'BoardReadPage',
                  params: { boardNo: boardGallery.boardNo.toString() } }">
            {{ boardGallery.title }}
          </router-link>
        </td>
        <td align="right">{{ boardGallery.writer }}</td>
        <td align="center">{{ boardGallery.regDate }}</td>
      </tr>
    </table>
  </div>
</template>

<script>

export default {
  name: 'BoardList',
  props: {
    boards: {
      type: Array
    }
  }
}
</script>
