<template>
<el-form style="width:50%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="图书名称" prop="name">
    <el-input v-model="ruleForm.name"></el-input>
  </el-form-item>
  <el-form-item label="作者" prop="author">
    <el-input v-model="ruleForm.author"></el-input>
  </el-form-item>
  <el-form-item label="出版社" prop="publish">
    <el-input v-model="ruleForm.publish"></el-input>
  </el-form-item>
  <el-form-item label="分类" prop="category">
    <el-input v-model="ruleForm.category"></el-input>
  </el-form-item>
  <el-form-item label="价格" prop="price">
    <el-input v-model="ruleForm.price"></el-input>
  </el-form-item>


  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">添加图书</el-button>
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
          author: '',
          publish: '',
          category: '',
          price: '',
        },

        rules: {
          name: [
            { required: true, message: '请输入图书名称', trigger: 'blur' }
          ],
          author: [
            { required: true, message: '请输入作者姓名', trigger: 'blur' }
          ],
          publish: [
            { required: true, message: '请输入出版社', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '请输入分类名', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '请输入价格', trigger: 'blur' }
          ],

        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8080/savebook',this.ruleForm).then(resp=>{
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