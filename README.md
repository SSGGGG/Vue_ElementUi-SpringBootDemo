#  项目介绍

原项目来源：https://github.com/yinjihuan/vue-elementui

该项目是一个Vue + elementui + SpringBoot的新手入门练手项目。对原项目中的代码增加了注释，并新增权限管理（自己练手的hh）

其中前端技术栈：

- vue
- vue-router：vue路由
- axios：异步调用api（类似ajax）
- vuex
- webpack
- elementui

后端技术栈：

- SpringBoot
- JWT Token认证

内置功能点：

- 登录页面：实现登录功能，登录成功后，服务端返回JWT的Token给客户端，客户端将token存储在vue的sessionStorage中
- 登录拦截判断：服务端设置过滤器，判断当前请求是否带有token，并验证token的有效性，客户端每次访问api请求都会将sessionStorage中的token放在request.Header.Authorization中
- 不同用户显示不同菜单
- vuex状态控制是否显示头部文字
- 表格数据展示
- 分页功能
- 文件上传
