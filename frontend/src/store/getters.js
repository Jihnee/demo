export default {
  isAuthorized (state) {
    return state.accessToken === undefined ? false : (state.accessToken.length > 0 && !!state.myinfo)
  },
  isSignUp (state) {
    return !state.isTrueSignUp
  }
}
