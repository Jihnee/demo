<template>
  <div class="board" style="height: 2000px">
    <p class="body-default"><br>
      <span style="font-weight: bolder; padding-left: 60px; font-size: 50px;">BOARD GALLERY</span>
    </p>
    <br><board-list/><br><br>
    <button class="hoo" @click="$router.push('BoardRegisterPage')" style="font-weight: bolder; font-size: 20px; color: white;
                                                        background-color: #FF6D00; padding: 20px; margin-left: 300px;
                                                        border-radius: 20px 30px 50px 80px; font-style: oblique;
                                                        ">
      CREATE NEW BOARD
    </button>
    <br><button class="hooo" @click="$router.push('/')"  style="background-color: #9E9D24; color: #9E9D24; padding: 150px; margin-top: 140px;
                                margin-left: 1400px; border-radius: 80px 80px 100px 30px">
    &nbsp;
  </button><br>
  </div>
</template>

<script>
import BoardList from '../components/BoardList'

export default {
  name: 'BoardGalleryPage',
  components: {
    BoardList
  }
}

</script>

<style>
.body-default {
    color: yellow;
    font-size: 32px;
}
.board {
  background: url('../assets/photo4.jpg') no-repeat right;
  background-size: 1200px;
}
.hooo{
  background: url('../assets/photo2.jpg') 100%;
}

</style>
