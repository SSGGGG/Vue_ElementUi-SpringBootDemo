/*
  store的用法：
    1. 定义index.js入口文件
    2. new Vues.store中定义modules/actions/state/getter/mutation等
      （这里将state/getter/mutation都放在了modules的mutations中）
*/

import Vue from 'vue'
import Vuex from 'vuex'
import mutations from './mutations'
import actions from './actions'

Vue.use(Vuex);

export default new Vuex.Store({

  modules: {
    mutations
  },
  actions
});