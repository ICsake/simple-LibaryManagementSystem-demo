<template>
  <el-table
    :data="tableData.filter(data => !search || data.user_name.toLowerCase().includes(search.toLowerCase()))"
    style="width: 80%">
    <el-table-column
      label="user_id"
      prop="user_id">
    </el-table-column>
    <el-table-column
      label="user_name"
      prop="user_name">
    </el-table-column>
    <el-table-column
      label="book_id"
      prop="book_id">
    </el-table-column>
    <el-table-column
      label="borrow_date"
      prop="borrow_date">
    </el-table-column>
    <el-table-column
      label="due_date"
      prop="due_date">
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
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">归还</el-button>
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
        search: ''
      }
    },
    methods: {
      handleDelete(index, row) {
        axios.delete('http://localhost:8080/returnbook/'+row.user_id+'/'+row.book_id).then(resp=>{
          this.$alert('归还成功!','消息',{
            confirmButtonText:'确定',
            callback:action => {
              window.location.reload()
            }
          })
        })
      }
    },
    created() {
      axios.get('http://localhost:8080/borrowlist/1/5').then(resp=>{
        console.log(resp)
        this.tableData = resp.data.list
        this.total = resp.data.total

      })
    }
  }
</script>t>