<template>
  <div class="wrapper">
    <!-- 组件标签 -->
    <fj-Header></fj-Header>
    <fj-Sidebar></fj-Sidebar>
    <div class="content">
      <!-- 元素过渡：这里包含着路由，说明路由元素采用过渡的方式 -->
      <transition name="move" mode="out-in">
        <router-view></router-view>
      </transition>
    </div>
  </div>
</template>

<script>
    // 导入两个组件标签
    import fjHeader from './common/Header.vue'
    import fjSidebar from './common/Sidebar.vue'
    // 导入api接口
    import {loadData} from '../api'

    export default {
      // 引入该组件依赖的子组件
      components: {
        fjHeader, 
        fjSidebar
      },
      // 生命周期钩子：在模板渲染成html后调用，通常是初始化页面完成后，再对html的dom节点进行一些需要的操作
      mounted() {
        this.load();
      },
      methods:{
        load() {
          loadData().then(function(response){
            console.log(response);
          });
        }
      }
    }
</script>