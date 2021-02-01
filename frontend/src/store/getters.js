export default {
  // isAuthorized (state) {
  //   return state.accessToken === undefined ? false : state.accessToken.length > 0 && !!state.infoToken
  // },
  isSignUp (state) {
    return state.isTrueSignUp
  },
  // 토큰이 저장되었는지 확인하려고 infoToken -> action -> Main.js
  isTrueAuth (state) {
    return state.accessToken === undefined ? false : state.accessToken.length > 0
  },
  getBoard (state) {
    return state.boards
  }
}
