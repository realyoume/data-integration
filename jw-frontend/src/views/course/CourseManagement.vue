<template>
  <Layout>
    <Title title="课程管理"></Title>

    <div style="margin-top: 10px">
      <el-table
          :data="courseList"
          stripe
          style="width: 100%"
          :header-cell-style="{'text-align':'center'}"
          :cell-style="{'text-align':'center'}"
      >
        <el-table-column
            prop="id"
            label="课程ID"
            >
        </el-table-column>
        <el-table-column
            prop="name"
            label="课程名称"
            >
        </el-table-column>
        <el-table-column
            prop="credit"
            label="学分"
            >
        </el-table-column>
        <el-table-column
            prop="teacher"
            label="教师"
            >
        </el-table-column>
        <el-table-column
            prop="position"
            label="地点"
           >
        </el-table-column>

      </el-table>
    </div>
  </Layout>
</template>

<script>
import Layout from "@/components/content/Layout";
import Title from "@/components/content/Title";
import {getAllCourse,getMyCourse, chooseCourse,unchooseCourse} from "@/network/course";
export default {
  name: 'AllCourse',
  components: {
    Layout,
    Title
  },
  inject:['reload'],
  data() {
    return {
      courseList:[],
      choosedCourseIdList:[],
      user:{}
    }
  },
  mounted() {
    getAllCourse({}).then(_res => {
      this.courseList =  _res.result
    })

  },
  methods: {
    refresh(){
      this.reload();
    },
    unchoose(){

    }
  }
}
</script>

<style>

</style>