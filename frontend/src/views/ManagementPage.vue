<template>
  <div class="management" style;="height: 2000px">
    <p class="body-default"><br>
      <span style="font-weight: bolder; padding-left: 60px; font-size: 50px;">
        MANAGEMENT PAGE
      </span>
    </p>
    <br><member-list/><br><br>
    <button class="hoo" @click="router.push('ManagementPage')" style="font-weight: bolder;
      font-size: 20px; color: white; background-color: #FF6D00; padding: 20px; margin-left: 300px;
      border-radius: 20px 30px 50px 80px; font-style: oblique">
      ADD MEMBER
    </button><br>
  </div>
</template>

<script>
import MemberList from '../components/MemberList'
import { mapActions, mapState } from "vuex";

export default {
  name: 'ManagementPage',
  components: {
    MemberList
  },
  computed: {
    ...mapState(['member'])
  },
  create () {
    this.memberList()
  },
  methods: {
    ...mapActions(['memberList'])
  }
}
</script>
