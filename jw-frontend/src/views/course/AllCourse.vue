<template>
  <Layout>
    <Title title="本院课程"></Title>

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

        <el-table-column
            label="状态">
          <template slot-scope="scope">
            <span v-if="isChosed(scope.row.id)" style="color: darkgreen">已选择</span>
          </template>
        </el-table-column>

        <el-table-column
            label="操作">
          <template slot-scope="scope">
            <el-button
                v-if="isChosed(scope.row.id)"
                @click.native.prevent="unchoose(scope.row.id)"
                type="text"
                size="small"
            >
              退选
            </el-button>
            <el-button
                v-if="!isChosed(scope.row.id)"
                @click.native.prevent="choose(scope.row.id)"
                type="text"
                size="small"
            >
              选择
            </el-button>
          </template>
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

    this.user.username = sessionStorage.getItem("name");
    getMyCourse(this.user).then(_res => {
      _res.result.forEach(course => {
          this.choosedCourseIdList.push(course.id)
      })
    })

  },
  methods: {
    refresh(){
      this.reload();
    },


    isChosed(id){
      console.log(id)
      if(sessionStorage.getItem("role") === 'ADMIN'){
        return true;
      }
      return this.choosedCourseIdList.indexOf(id) != -1;
    },
    choose(id){
      let config = {
        courseId: id,
        username:sessionStorage.getItem("name")
      };

      chooseCourse(config).then(_res => {
        if(_res.code === '00000'){
          this.$message({
            type: 'success',
            message: '选课成功'
          });
        }
      })

      this.refresh();
    },
    unchoose(id){
      let config = {
        courseId: id,
        username:sessionStorage.getItem("name")
      };

      unchooseCourse(config).then(_res => {
        if(_res.code === '00000'){
          this.$message({
            type: 'success',
            message: '退选成功'
          });
        }
      })

      this.refresh();
    },





  }
}
</script>

<style>

</style>