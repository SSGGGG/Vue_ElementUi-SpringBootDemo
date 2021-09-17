// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import AxiosPlugin from './libs/AxiosPlugin'
import store from './store/'

Vue.use(AxiosPlugin)
Vue.use(ElementUI);
Vue.config.productionTip = false;

// 前端判断sessionStorage中是否有token数据，并且判断路由是否正确
router.beforeEach((to, from, next) => {
  if (to.path != '/login') {
    var token = sessionStorage.getItem('token');
    if (token == null) {
       next({path:'/login'});
    } else {
      //根据后台返回的路由进行判断是否合法
      var routers = sessionStorage.getItem('routers');
      var flag = false;
      routers.split("_").forEach( v => {
        if(v == to.path) {
          flag = true;
        }
      });
      if(flag) {
       next();
      } else {
         next({path:'/home'});
      }
    }
  } else {
    next();
  }
})


/* eslint-disable no-new */
new Vue({
  // 使用store全局变量
  store,  
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
