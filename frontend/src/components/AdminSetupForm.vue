<template>
  <v-form @submit.prevent="{submit}">
    <v-container>
      <v-row>
        <v-col cols="12" sm="3">
          <v-text-field
            value=""
            label="ID "
            input type="text" v-model="userId"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="3">
          <v-text-field
            value=""
            label="Name "
            input type="text" v-model="userName"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="3">
          <v-text-field
            value=""
            label="Password "
            input type="password" v-model="userPw"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="3">
          <v-text-field
            value=""
            label="Confirmation Password "
            input type="password" v-model="userCPw"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="12">
          <v-text-field
            value=""
            label="가장 인상깊게 본 전시를 적어주세요"
            input type="text" v-model="fex"
            :rules="[rules.required, rules.counter]"
            counter
            maxlength="50"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="12">
          <v-text-field
            value=""
            label="좋아하는 아티스트를 적어주세요"
            input type="text" v-model="fartist"
            :rules="[rules.required, rules.counter]"
            counter
            maxlength="50"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="12">
          <v-text-field
            value=""
            label="E-mail address"
            input type="email" v-model="usere"
            :rules="[rules.required, rules.usere]"
          ></v-text-field>
        </v-col>
      </v-row>
    </v-container>
    <div>
      <v-btn type="submit" color="white--text" @click="submit">가입하기 </v-btn>
    </div>
  </v-form>
</template>

<script>

export default {
  name: 'AdminSetupForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: '',
      userCPw: '',
      fex: '',
      fartist: '',
      usere: '',
      rules: {
        required: value => !!value || 'Required.',
        counter: value => value.length <= 50 || 'Max 50 characters'
      },
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+\..+/.test(v) || 'E-mail must be valid'
      ]
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.userId + ', ' + this.userName + ', ' + this.userPw)
      const { userId, userName, userPw, fex, fartist, usere } = this
      this.$emit('submit', { userId, userName, userPw, fex, fartist, usere })
    }
  }
}
</script>
