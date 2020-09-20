<template>
  <div class="hello">
    <main-home-form>
    </main-home-form>
  </div>
</template>

<script>

import MainHomeForm from '@/components/MainHomeForm'

export default {
  name: 'Home',
  components: { MainHomeForm }
}

</script>

<style>
.hello {
   position: fixed;
   width: 170%;
   height: 500%;
   background: url('../assets/image3.jpeg');
   background-repeat: no-repeat;
}
</style>
