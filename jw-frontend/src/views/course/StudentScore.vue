<template>
  <Layout>
    <Title title="成绩分析"></Title>

    <div style="margin-top: 10px">
      <h3>请选择学生</h3>
      <el-select v-model="value" class="m-2" placeholder="请选择学生" size="large">
        <el-option
            v-for="item in studentList"
            :key="item.id"
            :label="item.id"
            :value="item.id"
        />
      </el-select>
      <el-button type="primary" @click="query()">查询学生</el-button>
      <br>
      <br>

      <div class="box-pie" style="height: 400px" ref="chart"></div>

      <el-table
          :data="scoreList"
          stripe
          style="width: 100%"
          :header-cell-style="{'text-align':'center'}"
          :cell-style="{'text-align':'center'}">
        <el-table-column
            prop="courseId"
            label="课程ID"
        >
        </el-table-column>
        <el-table-column
            prop="grade"
            label="成绩"
        >
        </el-table-column>

        <el-table-column
            label="操作">
          <template slot-scope="scope">
            <el-button
                @click.native.prevent="update(scope.row.courseId)"
                type="text"
                size="small"
            >
              编辑
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog
        title="编辑成绩"
        :visible.sync="dialogVisible"
        width="36%">
      <div style="width: 90%; margin: 0 auto">
        <el-form :model="updateForm" label-width="100px" ref="updateForm">
          <el-form-item label="课程ID: " prop="name">
            <span>{{ updateForm.courseId }}</span>
          </el-form-item>
          <el-form-item label="成绩: " prop="phone">
            <el-input style="width: 50%;" v-model="updateForm.grade"></el-input>
          </el-form-item>

        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submit()">确认</el-button>
      </span>
    </el-dialog>
  </Layout>
</template>



<script>
import Layout from "@/components/content/Layout";
import Title from "@/components/content/Title";
import {getScoresById, updateScore, getScorePercent} from "@/network/score";
import {getAllStudent} from "@/network/course";

export default {
  name: 'StudentManagement',
  components: {
    Layout,
    Title
  },
  data() {
    return {
      studentList: [],
      value: "",
      options: [],
      scoreList: [],
      dialogVisible: false,
      updateForm: {
        id: "",
        courseId: "",
        grade: ""
      },
      chart:null,
      // 配置可视化图形
      option:  {
        title: {
          text: '成绩分布',
          subtext: '分数构成',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: '50%',
            data: [
              { value: 0, name: '90~100' },
              { value: 0, name: '80~89' },
              { value: 0, name: '70~79' },
              { value: 0, name: '60~69' },
              { value: 0, name: '0~59' }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      }
    }
  },
  async mounted() {
    await getAllStudent({}).then(_res => {
      this.studentList = _res.result
    })
    this.getPage();
  },
  watch:{
    scoreList(old){
      this.draw();
    }
  },
  methods: {
    query() {
      let config = {
        id: this.value,
      };

      getScoresById(config).then(_res => {
        this.scoreList = _res.result
      });
    },
    update(courseId) {
      this.scoreList.forEach(item => {

        if (item.courseId === courseId) {
          this.updateForm.id = item.id;
          this.updateForm.courseId = item.courseId;
          this.updateForm.grade = item.grade;
        }

      })
      this.dialogVisible = true;
    },
    submit() {
      this.updateForm.studentId = this.value;
      updateScore(this.updateForm).then(_res => {
        if (_res.code === "00000") {
          this.$message.success("修改成功")
          this.query();
          this.dialogVisible = false;
        }
      })
    },
    getPage() {
      // 引用chart并初始化
      this.chart = this.$echarts.init(this.$refs.chart);
      // 使用刚指定的配置项和数据显示图表。
      this.chart.setOption(this.option);
    },
    draw(){
      let counts = [0,0,0,0,0];

      this.scoreList.forEach(item => {
        let score = item.grade;
        if(score >= 90){
          counts[0]++;
        }else if(score >= 80){
          counts[1]++;
        }else if(score >= 70){
          counts[2]++;
        }else if(score >= 60){
          counts[3]++;
        }else {
          counts[4]++;
        }
      })

      for (let i = 0; i < 5; i++) {
        this.option.series[0].data[i].value = counts[i];
      }

      this.chart.setOption(this.option);

    }
  }
}
</script>

<style>

</style>