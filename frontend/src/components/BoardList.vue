<template>
  <div>
    <br><button class="hoo3" @click="$router.push('/')" style="color: #9E9D24; padding: 130px;
                                margin-left: 800px">&nbsp;
    </button>
    <table class="tabl" border="1" style="border-radius: 400px 70px 50px 100px;
                                  margin-left: 300px; margin-top: 100px">
      <tr class="tabl-text">
        <th width="110" height="50">BOARD <br>No. </th>
        <th width="520">TITLE</th>
        <th width="100">WRITER</th>
        <th width="150" style="color: black">DATE</th>
      </tr>

      <tr v-if="(Array.isArray(boards) && boards.length === 0)">
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
      <br><button :disabled="pageNum === 0"
              @click="prevPage" class="page-btn" style="margin-left: 300px; color: white; padding: 10px">
        이전
      </button>&nbsp;
      <span class="page-count" style="background-color: #CFD8DC; border-radius: 20px 20px 20px 20px; font-family: Impact, Charcoal, sans-serif;
                                      font-style: oblique; padding: 10px">{{ pageNum + 1 }} / {{ pageCount }}</span>&nbsp;
      <button :disabled="pageNum >= pageCount - 1"
              @click="nextPage" class="page-btn" style="color: white; padding: 10px">
        다음
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
  background-color:
    #B2DFDB;
  text-align: center;
  border: #37474F;
}
.tabl-text {
  font-size: 15px;
}
.page-btn {
  background-color: mediumslateblue;
  border-radius: 100px 40px 70px 10px;
}
.hoo3 {
  background: url('../assets/photo2.jpg') 150%;
}
</style>
