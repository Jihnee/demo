<template>
  <div>
    <table class="tab1" border="1" style="border-radius: 400px 70px 50px 100px;
           margin-left: 300px; margin-top: 100px">
      <tr class="tab1-text">
        <th width="110" height="50">USER <br>No. </th>
        <th width="200">USER_ID</th>
        <th width="200">USER_NAME</th>
        <th width="400">INFO_1</th>
        <th width="400">INFO_2</th>
        <th width="200">USER EMAIL</th>
      </tr>

      <tr v-for="member in member" :key="member.userNo">
        <td style="font-size: 30px; font-weight: bolder">
          {{ member.userNo }}
        </td>
        <td style="font-size: 30px; font-weight: bolder">
          {{ member.userId }}
        </td>
        <td style="font-size: 30px; font-weight: bolder">
          {{ member.userName }}
        </td>
        <td style="font-size: 30px; font-weight: bolder">
          {{ member.fartist }}
        </td>
        <td style="font-size: 30px; font-weight: bolder">
          {{ member.fex }}
        </td>
        <td style="font-size: 30px; font-weight: bolder">
          {{ member.userE }}
        </td>
      </tr>
    </table>
  </div>
</template>

<script>

import { mapState } from "vuex";

export default {
  name: 'MemberList',
  props: {
    member: {
      type: Array
    }
  }
}
</script>
