import {
  SET_ACCESS_TOKEN,
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO,
  FETCH_BOARD, FETCH_BOARD_LIST, SET_MY_INFO, FETCH_MEMBER_LIST
} from './mutation-types'

import axios from 'axios'
import cookies from 'vue-cookies'

// api -> action -> mutation -> state -> component

export default {
  // state에 있는 accessToken을 쓰겠다는 뜻
  [SET_ACCESS_TOKEN] (state, accessToken) {
    if (accessToken) {
      state.accessToken = accessToken

      axios.defaults.headers.common.Authorization = `Bearer ${accessToken}`
      console.log('axios Auth: ' + axios.defaults.headers.common.Authorization)

      cookies.set('accessToken', accessToken, '1h')
    }
  },
  [SET_MY_INFO] (state, isAuthorized) {
    if (isAuthorized) {
      state.isAuthorized = isAuthorized
    }
  },
  [DESTROY_ACCESS_TOKEN] (state) {
    state.accessToken = ''
    delete axios.defaults.headers.common.Authorization
    cookies.remove('accessToken')
  },
  [DESTROY_MY_INFO] (state) {
    state.infoToken = null
  },
  [FETCH_BOARD] (state, boardGallery) {
    state.boardGallery = boardGallery
  },
  [FETCH_BOARD_LIST] (state, boards) {
    state.boards = boards
  },
  [FETCH_MEMBER_LIST] (state, member) {
    state.member = member
  }
}
