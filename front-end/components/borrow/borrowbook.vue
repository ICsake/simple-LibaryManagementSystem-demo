<template>
  <el-form  style="width: 50%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="读者id" prop="user_id">
      <el-input v-model="ruleForm.user_id"></el-input>
    </el-form-item>
    <el-form-item label="书本id" prop="book_id">
      <el-input v-model="ruleForm.book_id"></el-input>
    </el-form-item>

    <el-form-item label="借出时间" required>
      <el-col :span="11">
        <el-form-item prop="date1">
          <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date1" style="width: 100%;"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-form-item>
    <el-form-item label="归还时间" required>
      <el-col :span="11">
        <el-form-item prop="date1">
          <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date2" style="width: 100%;"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">确认借阅</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>

  </el-form>
</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
          user_id:'',
          book_id:'',
          date1: '',
          date2: ''

        },
        rules: {
          user_id: [
            { required: true, message: '请输入读者id', trigger: 'blur' },
          ],
          user_name: [
            { required: true, message: '请输入读者姓名', trigger: 'blur' },
          ],
          book_id: [
            { required: true, message: '请输入书本id', trigger: 'blur' },
          ],
          book_name: [
            { required: true, message: '请输入书本名称', trigger: 'blur' },
          ],
          date1: [
            { type: 'date', required: true, message: '请选择借出日期', trigger: 'change' }
          ],
          date2: [
            { type: 'date', required: true, message: '请选择归还日期', trigger: 'change' }
          ],

        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8080/borrowbook/'+this.ruleForm.user_id+'/'+this.ruleForm.book_id+'/'+this.ruleForm.date1+'/'+this.ruleForm.date2).then(resp=>{
              if(resp.data=='success'){
                this.$message("添加成功")
              }
            })
          } else {
            console.log('error submit!!');
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