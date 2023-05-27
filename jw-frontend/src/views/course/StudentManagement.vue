<template>
  <Layout>
    <Title title="学生管理"></Title>

    <div style="margin-top: 10px">
      <el-table
          :data="studentList"
          stripe
          style="width: 100%"
          :header-cell-style="{'text-align':'center'}"
          :cell-style="{'text-align':'center'}">
        <el-table-column
            prop="id"
            label="学生ID"
            >
        </el-table-column>
        <el-table-column
            prop="name"
            label="姓名"
            >
        </el-table-column>

        <el-table-column
            prop="gender"
            label="性别"
        >
          <template slot-scope="scope">
            <span v-if="scope.row.gender === '0'">女</span>
            <span v-if="scope.row.gender === '1'">男</span>
          </template>
        </el-table-column>

        <el-table-column
            prop="department"
            label="学院"
            >
        </el-table-column>

        <el-table-column
            prop="username"
            label="用户名"
            >
        </el-table-column>



      </el-table>
    </div>
  </Layout>
</template>

<script>
import Layout from "@/components/content/Layout";
import Title from "@/components/content/Title";
import {getAllStudent} from "@/network/course";
export default {
  name: 'StudentManagement',
  components: {
    Layout,
    Title
  },
  data() {
    return {
      studentList:[]
    }
  },
  async mounted() {
    await getAllStudent({}).then(_res => {
      this.studentList =  _res.result
    })
  },
  methods: {
  }
}
</script>

<style>

</style>