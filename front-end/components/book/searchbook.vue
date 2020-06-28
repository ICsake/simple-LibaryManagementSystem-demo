<template>
  <div>
  <el-table
    :data="tableData"
    border
    style="width: 60%">
    <el-table-column
      fixed
      prop="id"
      label="编号"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="书名"
      width="150">
    </el-table-column>
    <el-table-column
      prop="author"
      label="作者"
      width="150">
    </el-table-column>
    <el-table-column
      prop="publish"
      label="出版社"
      width="120">
    </el-table-column>
    <el-table-column
      prop="category"
      label="分类"
      width="120">
    </el-table-column>
    <el-table-column
      prop="price"
      label="价格"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
        <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

    <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      page-size="6"
      @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
  export default {
    methods: {
      edit(row) {
        this.$router.push({
          path:'/BookUpdate',
          query:{
            id : row.id
          }
        })
      },
      deleteBook(row){
        axios.delete('http://localhost:8080/deleteById/'+row.id).then(resp=>{
          this.$alert('删除成功!','消息',{
            confirmButtonText:'确定',
            callback:action => {
              window.location.reload()
            }
          })
        })
      },
      page(currentPage){
        axios.get('http://localhost:8080/pagebooks/'+currentPage+'/5').then(resp=>{
          this.tableData = resp.data.list
          this.total = resp.data.total
        })
      }
    },

    created() {
      axios.get('http://localhost:8080/pagebooks/1/5').then(resp=>{
        console.log(resp)
        this.tableData = resp.data.list
        this.total = resp.data.total

      })
    },

    data() {
      return {

        total:null,
        tableData:[]
      }
    }
  }
</script>