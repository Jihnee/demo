<template>
  <v-form @submit.prevent="{submit}"><br>
    <v-container>
      <v-row>
        <v-col cols="3">
          <v-text-field
            value=""
            label="ID"
            style="font-weight: bolder; background-color: #FFB300;
                  border-radius: 20px 10px 60px 20px;
                  padding-left: 10px; padding-top: 10px"
            input type="text" v-model="userId"
          ></v-text-field>
        </v-col>
        <v-col cols="3">
          <v-text-field
            value=""
            label="Name"
            input type="text" v-model="userName"
            style="font-weight: bolder; background-color: #FFB300;
                  border-radius: 50px 70px 40px 80px"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="3">
          <v-text-field
            value=""
            label="Password"
            input type="password" v-model="userPw"
            style="font-weight: bolder; background-color: #FFB300;
                  border-radius: 20px 80px 10px 60px"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="3">
          <v-text-field
            value=""
            label="Confirmation Password"
            input type="password" v-model="userCPw"
            style="font-weight: bolder; background-color: #FFB300;
                  border-radius: 70px 30px 70px 40px"
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
            style="font-weight: bolder; background-color: #FFB300;
                  border-radius: 100px 50px 70px 40px"
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
            style="font-weight: bolder; background-color: #FFB300;
                  border-radius: 20px 50px 10px 80px"
          ></v-text-field>
        </v-col>
        <v-col cols="5" style="padding: 10px">
          <v-text-field
            value=""
            label="E-mail address"
            input type="email" v-model="userE"
            :rules="[rules.required, rules.userE]"
            style="font-weight: bolder; background-color: #FFB300;
                  border-radius: 30px 10px 10px 40px"
          ></v-text-field>
        </v-col>
      </v-row>
    </v-container><br><br><br><br>
    <div class="ddd" style="margin-left: 800px">
      <button type="submit" @click="submit" style="font-weight: bolder; font-size: 32px; color: white">SIGN UP</button>
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
      userE: '',
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
      const { userId, userName, userPw, fex, fartist, userE } = this
      this.$emit('submit', { userId, userName, userPw, fex, fartist, userE })
    }
  }
}
</script>
