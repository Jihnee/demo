<template>
  <div>
    <table class="tabl" border="5" style="border-radius: 500px 70px 20px 100px;
                                  margin-left: 500px; margin-top: 100px">
      <tr class="tabl-text">
        <th width="110" height="50">BOARD <br>No. </th>
        <th width="520">TITLE</th>
        <th width="100">WRITER</th>
        <th width="150" style="color: silver">DATE</th>
      </tr>

      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">
          ☞ ⓝⓞ  ㉠ㅔ㉦ㅣ물  ΝΘω ☜
        </td>
      </tr>
      <tr v-for="page in paginatedData" :key="page.boardNo">
        <td style="font-size: 30px; font-weight: bolder">{{ page.boardNo }}</td>
        <td style="font-size: 25px; height: 100px"><router-link :to="{ name: 'BoardReadPage',
                  params: { boardNo: page.boardNo.toString() } }">
          {{ page.title }}
        </router-link></td>
        <td>{{ page.writer}}</td>
        <td>{{ page.regDate }}</td>
      </tr>
    </table>
    <div class="btn-cover">
      <button :disabled="pageNum === 0"
              @click="prevPage" class="page-btn">
        이전
      </button>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1"
              @click="nextPage" class="page-btn">
        다
      </button>

    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardList',
  data () {
    return {
      pageNum: 0
    }
  },
  computed: {
    ...mapState(['boards']),

    pageCount () {
      const listLen = this.boards.length
      const listSize = this.pageSize

      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }

      return page
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize
      return this.boards.slice(start, end)
    }
  },
  created () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList']),

    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    }
  },
  props: {
    pageSize: {
      type: Number,
      required: true,
      default: 5
    }
  }
}
</script>

<style>
.tabl {
  background-color: #69F0AE;
  text-align: center;
  border: solid #37474F;
}
.tabl-text {
  font-size: 15px;
  background-color: #CDDC39;
}
</style>
