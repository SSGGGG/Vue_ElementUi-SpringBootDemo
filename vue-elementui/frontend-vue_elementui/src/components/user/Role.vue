<template>
    <div>
        <!-- 行内表单 -->
        <el-form :inline="true" class="demo-form-inline">
            <el-form-item label="角色名">
                <el-input placeholder="如：ADMIN"></el-input>
            </el-form-item>

            <el-form-item label="权限">
                <el-input placeholder="如：/user"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
        </el-form>
        
        <!-- 表格显示 -->
        <el-table :data="tableData" style="width: 100%" v-loading="ifLoading" element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="id" label="id" width="100"></el-table-column>
            <el-table-column prop="name" label="角色名" width="180"></el-table-column>
            <el-table-column prop="privilege" label="权限"></el-table-column>
                <template scope="scope">
                    <el-button type="text" size="small" @click="showInfo(scope.$index)">查看</el-button>
                    <el-button type="text" size="small" @click="showEdit(scope.$index)">编辑</el-button>
                    <el-button type="text" size="small" @click="showDelete(scope.$index)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 批量删除以及分页组件 -->
        <div class="footer_div">
            <div class="r_btn left_button">
                <el-button type="primary" @click="batchRemove">批量删除</el-button>
            </div>
            <div class="right_page">
                <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-sizes="[10, 20]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script type="text/javascript">

    // 导入API接口
    import {getRoleList} from '../../api'

    export default{
        data(){
            return{
                // 表格的数据
                tableData: [],
                ifLoading: false,
                currentPage:1,
                total:0,
                pageSize: 5,
                multipleSelection: []
            }
        },
        mounted() {
            this.loadData();
        },
        methods: {
            // 调用接口加载数据
            loadData(){
                this.ifLoading = true;
                var params = {
                    page: this.currentPage,
                    pageSize: this.pageSize
                };
                getRoleList(params).then(function(result){
                    this.tableData = result.data.list;
                    this.total = result.data.total;
                    this.ifLoading = false;
                }.bind(this)).catch(function(error){
                    this.ifLoading = false;
                    this.$message({
                        type: 'error',
                        message: '加载数据出现异常!'
                    });
                }.bind(this));
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            onSubmit() {
                console.log('onSubmit()');
            },
            // 打开查看窗口
            showInfo(row){
                console.log('showInfo()'+row);
            },
            showEdit(row){
                console.log('showEdit()'+row);
            },
            showDelete(row){
                console.log('showDelete()'+row);
            },
            // 更改分页的大小
            handleSizeChange(val){
                this.pageSize = val;
            },
            // 跳转页数
            handleCurrentChange(val){
                this.currentPage = val;
            },
            // 批量删除
            batchRemove(){
                this.multipleSelection.forEach(row => {
                    console.log(row.id);
                })
            }
        }
    }
</script>


<style scoped>
    .footer_div{
        margin-top: 20px;
    }
    .left_button{
        float: left;
    }
    .right_page{
        float: right;
    }
</style>