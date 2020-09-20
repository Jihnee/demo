<template>
  <div class="exhibition">
    <Wexhibition-Form>
    </Wexhibition-Form>
  </div>
</template>

<script>
import WexhibitionForm from '@/components/WexhibitionForm'

export default {
  name: 'WexhibitionPage',
  components: { WexhibitionForm }
}
</script>

<style>
.exhibition {
  background: url('../assets/oeuvre1.jpg') left, url('../assets/oeuvre2.jpg') right;
}
</style>
