<template>
  <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    style="width: 80%">
    <el-table-column
      label="Id"
      prop="id">
    </el-table-column>
    <el-table-column
      label="Name"
      prop="name">
    </el-table-column>
    <el-table-column
      label="Phone"
      prop="phone">
    </el-table-column>
    <el-table-column
      label="Email"
      prop="email">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>

   <!-- <el-pagination
      page-size="5"
      background
      layout="prev, pager, next"
      :total="total">
    </el-pagination>-->

  </el-table>

</template>

<script>
  export default {
    data() {
      return {
        tableData: [],
        total:null,
        search: ''
      }
    },
    methods: {
      handleEdit(index, row) {
        this.$router.push({
          path:'/UserUpdate',
          query:{
            id : row.id
          }
        })
      },
      handleDelete(index, row) {
        axios.delete('http://localhost:8080/deleteUserById/'+row.id).then(resp=>{
          this.$alert('删除成功!','消息',{
            confirmButtonText:'确定',
            callback:action => {
              window.location.reload()
            }
          })
        })
      }
    },
    created() {
      axios.get('http://localhost:8080/userpages/1/5').then(resp=>{
        this.tableData = resp.data.list
        this.total = resp.data.total

      })
    }
  }
</script>