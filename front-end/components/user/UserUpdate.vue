<template>
  <el-form style="width:50%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="读者姓名" prop="name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="手机号码" prop="phone">
      <el-input v-model="ruleForm.phone"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="ruleForm.email"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">添加读者</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
          name: '',
          phone: '',
          email: ''
        },

        rules: {
          name: [
            { required: true, message: '请输入读者姓名', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '请输入读者手机号', trigger: 'blur' },
          ],
          email: [
            { required: true, message: '请输入读者邮箱', trigger: 'blur' }
          ],

        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.put('http://localhost:8080/updateuser',this.ruleForm).then(resp=>{
              if (resp.data == 'success') {
                this.$alert('修改成功!','消息',{
                  confirmButtonText:'确定',
                  callback:action => {
                    this.$router.push('/Pagethree')
                  }
                })
              }
            })

          } else {
            this.$message("修改失败！！")
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },

    created(){
      axios.get('http://localhost:8080/queryUserById/'+this.$route.query.id).then(resp =>{
        this.ruleForm=resp.data
      })
    }
  }
</script>