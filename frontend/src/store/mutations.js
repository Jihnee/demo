import {
  SET_ACCESS_TOKEN,
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO, FETCH_BOARD, FETCH_BOARD_LIST, SET_MY_INFO
} from './mutation-types'

import axios from 'axios'
import cookies from 'vue-cookies'

// api -> action -> mutation -> state -> component

export default {
  [SET_ACCESS_TOKEN] (state, accessToken) {
    if (accessToken) {
      state.accessToken = accessToken

      axios.defaults.headers.common.Authorization = `Bearer ${accessToken}`
      console.log('axios Auth: ' + axios.defaults.headers.common.Authorization)

      cookies.set('accessToken', accessToken, '1h')
    }
  },
  [SET_MY_INFO] (state, infoToken) {
    if (infoToken) {
      state.infoToken = infoToken
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
  }
}
