<template>
    <div class="sidebar">
        <!-- 侧导航栏 -->
        <el-menu :default-active="onRoutes" class="el-menu-vertical-demo" theme="light" unique-opened router>
            <!-- 遍历items -->
            <template v-for="item in items">
                <!-- 判断item是否有子菜单subs -->
                <template v-if="item.subs">
                    <!-- 若有子菜单的情况，则显示当前item.title，再for循环子菜单item.subs -->
                    <el-submenu :index="item.index">
                        <template slot="title"><i :class="item.icon"></i>{{ item.title }}</template>
                        <el-menu-item v-for="(subItem,i) in item.subs" :key="i" :index="subItem.index">{{ subItem.title }}</el-menu-item>
                    </el-submenu>
                </template>
                <template v-else>
                    <!-- 若没有子菜单，则直接采用el-menu-itme标签显示 -->
                    <el-menu-item :index="item.index">
                        <i :class="item.icon"></i>{{ item.title }}
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                items: [
                    // {
                    //     icon: 'el-icon-setting',
                    //     index: '/home',
                    //     title: '首页'
                    // },
                    // {
                    //     icon: 'el-icon-menu',
                    //     index: '2',
                    //     title: '用户管理',
                    //     subs: [
                    //         {
                    //             index: '/users',
                    //             title: '用户列表'
                    //         }
                    //     ]
                    // }
                ]
            }
        },
        beforeMount() {
            var meuns = sessionStorage.getItem('meuns');
            // 通过require获取qs插件，调用parse()方法序列化为json格式
            var qs = require('qs'); 
            this.items = qs.parse(meuns);
        },
        // 计算属性
        computed: {
            onRoutes(){
                console.log(this.$route.path);
                return this.$route.path;
            }
        }
    }
</script>

<style scoped>
    .sidebar{
        display: block;
        position: absolute;
        width: 200px;
        left: 0;
        top: 70px;
        bottom:0;
        background: #2E363F;
    }
    .sidebar > ul {
        height:100%;
    }
</style>