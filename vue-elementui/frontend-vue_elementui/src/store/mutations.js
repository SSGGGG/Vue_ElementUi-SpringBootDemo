import * as types from './mutation-types'
import getters from './getters'

// 状态变量
const state = {
  headerStatus:true
};

// 类似事件，更改state的值
const mutations = {
  [types.SHOW_HEADER](state) {
    state.headerStatus = true;
  },
  [types.HIDE_HEADER](state) {
    state.headerStatus = false;
  }
};

// 包含state/mutations/getters
export default {
  state,
  mutations,
  getters
}