<template>
  <Layout>
    <Title title="我的课程"></Title>

    <div style="margin-top: 10px">
      <el-table
          :data="courseList"
          stripe
          style="width: 100%"
          :header-cell-style="{'text-align':'center'}"
          :cell-style="{'text-align':'center'}">
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
            prop="share"
            label="是否共享"
            >
          <template slot-scope="scope">
            <span v-if="scope.row.share === '0'">本院系</span>
            <span v-if="scope.row.share === '1'" style="color: coral;">跨院系</span>
          </template>
        </el-table-column>

        <el-table-column
            label="操作">
          <template slot-scope="scope">
            <el-button
                @click.native.prevent="unchoose(scope.row.id)"
                type="text"
                size="small"
            >
              退选
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
import {getMyCourse, unchooseCourse} from "@/network/course";
export default {
  name: 'MyCourse',
  components: {
    Layout,
    Title
  },
  inject:['reload'],
  data() {
    return {
      courseList:[],
      user:{
        username:""
      }
    }
  },
  async mounted() {
    this.user.username = sessionStorage.getItem("name");
    await getMyCourse(this.user).then(_res => {
      this.courseList =  _res.result
    })
  },
  methods: {
    refresh(){
      // this.user.username = sessionStorage.getItem("name");
      // getMyCourse(this.user).then(_res => {
      //   this.courseList =  _res.result
      // })

      this.reload();
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