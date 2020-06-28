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
            axios.post('http://localhost:8080/saveuser',this.ruleForm).then(resp=>{
              if(resp.data=='success'){
                this.$message("添加成功")
              }
            })

          } else {
            console.log('提交失败!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>