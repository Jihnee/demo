<template>
  <v-form @submit.prevent="submit" >
    <v-row>
      <v-col cols="3"
             style="background-color: #FFB300; padding-bottom: 5px; border-radius: 10px 20px 30px 10px;
                    margin: 10px 50px 180px 900px">
        <v-text-field
          v-model="userid"
          label="Id"
          clearable
        ></v-text-field>
      </v-col>
      <v-col cols="5" style="background-color: #42A5F5; border-radius: 10px 80px 30px 80px;
                            margin-bottom: 150px; margin-left: 150px">
        <v-text-field
          v-model="password"
          label="Password"
          clearable>
        </v-text-field>
      </v-col>
      <div class="text-center">
        <button @click="submit" :isAuthorized="isAuthorized"
                  style="padding-left: 10px; height: 100px">CONNECT<br>CONNECT<br>CONNECT<br>CONNECT
          <br>CONNECT</button>
      </div>
    </v-row>
  </v-form>
</template>

<script>
export default {
  name: 'LoginForm',
  data () {
    return {
      userid: '',
      password: ''
    }
  },
  methods: {
    submit () {
      console.log('LoginForm submit()')
      const { userid, password } = this
      this.$emit('submit', { userid, password })
    }
  }
}
</script>

<style>
.text-center {
  background-color: teal;
  border-radius: 10px 50px 20px 80px;
  padding: 70px 10px;
}
</style>
