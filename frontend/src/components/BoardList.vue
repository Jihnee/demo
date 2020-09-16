<template>
  <div>
    <table class="tr" border="5" bordercolor="yellow" style="center">
      <tr align="center">
        <th align="center" width="100">NO.</th>
        <th align="center" width="420">TITLE </th>
        <th align="center" width="200">WRITER </th>
        <th align="center" width="250">REGISTRATION DATE </th>
      </tr>

      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">
          ☞ ⓝⓞ  ㉠ㅔ㉦ㅣ물  ΝΘω ☜
        </td>
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

<style>
.tr {
  max-width: 800px;
  margin-right: auto;
  margin-left: auto;
  color: teal;
}
</style>
