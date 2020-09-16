<template>
  <div id="board">
    <layout>
      <template #content>
        <p class="body-default">
          <span>※『 ㉠ㅔ㉦ㅣ㉺㉡ 』※</span>
        </p>
          <br><v-row justify="center">
            <div class="BT">
              <v-btn class="BT" @click="$router.push('BoardRegisterPage')"
                outlined color="lime accent-3 black--text">
                ⓒⓡⓔⓐⓣⓔ → ⓝⓔⓦ ←  ⓑⓞⓐⓡⓓ
              </v-btn>
            </div>
          </v-row>
        <br><board-list :boards="boards"/>
      </template>
    </layout>
  </div>
</template>

<script>
import Layout from '../components/Layout'
import BoardList from '../components/BoardList'

import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardGalleryPage',
  components: {
    Layout,
    BoardList
  },
  computed: {
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}

</script>

<style>
  .body-default {
    color: yellow;
    font-size: 32px; }
</style>
