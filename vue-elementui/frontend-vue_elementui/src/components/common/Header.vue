<template>
    <div class="header">
        <!-- v-show判断当前元素是否显示 -->
        <div class="logo" v-show="headerStataus">后台管理系统</div>
        <div class="user-info">
            <!-- 下拉框,其中@command绑定方法 -->
            <el-dropdown trigger="click" @command="handleCommand">
                <span class="el-dropdown-link">
                    <!-- <img class="user-logo" src="../../../static/img/img.jpg"> -->
                    用户：{{username}}
                </span>
                <!-- 下拉菜单 -->
                <el-dropdown-menu slot="dropdown">
                    <!-- 下拉项 -->
                    <el-dropdown-item command="loginout">退出</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                name: ''
            }
        },
        // computed：计算属性
        computed:{
            username(){
                let username = sessionStorage.getItem('login_username');
                return username ? username : this.name;
            },
            headerStataus() {
                // 获取当前Vue实例的store实例对象(全局变量)
                return this.$store.getters.getHeaderStatus
            }
        },
        methods:{
            handleCommand(command) {
                if(command == 'loginout'){
                    sessionStorage.removeItem('login_username');
                    sessionStorage.removeItem('token');
                    // 在Vue实例内部，可以通过$router获取router的实例，因此可以调用push方法导航到其他的url（当客户端点击返回的时候，会返回到当前页面）
                    this.$router.push('/login');
                }
            }
        }
    }
</script>
<style scoped>
    .header {
        position: relative;
        box-sizing: border-box;
        width: 100%;
        height: 70px;
        font-size: 22px;
        line-height: 70px;
        color: #fff;
    }
    .header .logo{
        float: left;
        width:250px;
        text-align: center;
    }
    .user-info {
        float: right;
        padding-right: 50px;
        font-size: 16px;
        color: #fff;
    }
    .user-info .el-dropdown-link{
        position: relative;
        display: inline-block;
        padding-left: 50px;
        color: #fff;
        cursor: pointer;
        vertical-align: middle;
    }
    .user-info .user-logo{
        position: absolute;
        left:0;
        top:15px;
        width:40px;
        height:40px;
        border-radius: 50%;
    }
    .el-dropdown-menu__item{
        text-align: center;
    }
</style>
