<template>
  <div class="backgggg" style="height: 1000px">
    <info-form></info-form>
  </div>
</template>

<script>
import InfoForm from '@/components/InfoForm'

export default {
  name: 'InfoPage',
  components: { InfoForm }
}
</script>

<style>
.backgggg {
  background: url('../assets/photo5.jpeg') center no-repeat;
  background-size: 1000px;
}
</style>
