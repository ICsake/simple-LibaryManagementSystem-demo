<template>
  <div class="login-wrap">
    <el-form class="login-form" label-position="top" label-width="80px" :model="formdata">
      <h2>登陆</h2>
      <el-form-item label="用户名">
        <el-input v-model="formdata.name"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="formdata.pwd"></el-input>
      </el-form-item>
      <el-button type="primary" class="login-btn" @click="login('formdata')">登陆</el-button>
    </el-form>

  </div>
</template>

<script>
  export default {
    data(){
      return{
        formdata:{
          name:'',
          pwd:'',
        }
      }
    },
    methods:{
      login(formName){
        console.log(this.formdata)
        axios.post("http://localhost:8080/login",this.formdata).then(resp=>{
          if(resp.data.msg=="success"){
            this.$message("登陆成功")
            this.$router.push('/home')
          }
          else{
            const err = resp.data.msg;
            this.$message(err)
          }
        })
      }
    }
  }
</script>

<style scoped>
.login-wrap{
  height: 100%;
  background-color: #324152;
  display: flex;
  justify-content: center;
  align-items: center;
}
  .login-wrap .login-form{
    width: 400px;
    background-color: #ffffff;
    padding: 30px;
  }
  .login-wrap .login-btn{
    width: 100%;
  }
</style>