<template>
  <el-container class="container">
    <el-header class="header">
      <el-row>
      <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="23" class="middle">
        <h3>图书后台管理系统</h3>
      </el-col>
      <el-col :span="1"><div class="grid-content bg-purple">
        <a href="#" class="loginout">注销</a>
      </div>
      </el-col>
    </el-row>
    </el-header>
    <el-container>


      <el-aside class="aside" width="200px">
        <el-menu router
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>图书管理</span>
            </template>

              <el-menu-item index="searchbook">图书查询</el-menu-item>
              <el-menu-item index="addbook">添加图书</el-menu-item>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>读者管理</span>
            </template>

            <el-menu-item index="searchuser">读者查询</el-menu-item>
            <el-menu-item index="adduser">添加读者</el-menu-item>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>借阅管理</span>
            </template>

            <el-menu-item index="borrowbook">借阅登记</el-menu-item>
            <el-menu-item index="returnbook">归还书籍</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>



      <el-main class="main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    //获取token：1、有渲染，2、无-登陆界面
    /*beforeCreate() {
      const token = localStorage.getItem('token')
      if(!token){
        this.$router.push({name: 'login'})
      }
    },*/
    methods:{
      handleSignout(){
        localStorage.clear();
        this.$message.success('已注销')
        this.$router.push({name:'login'})
      }
    }
  }
</script>

<style scoped>
  .container{
    height: 100%;
  }
  .header{
    background-color: #b3c0d1;
  }
  .aside{
    background-color: #d3dcd6;
  }
  .main{
    background-color: #e9eef3;
  }
  .middle{
    /*line-height: 60px;*/
    text-align: center;
  }
  .loginout{
    line-height: 60px;
    text-decoration: none;
  }

</style>