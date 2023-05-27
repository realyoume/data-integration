package com.jw.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@TableName("ROOT.COURSESELECTION")
public class CourseSelection {


    /**
     * 课程id
     */
    @TableField("CNO")
    private String courseId;

    /**
     * 学生id
     */
    @TableField("SNO")
    private String studentId;

    /**
     * 成绩
     */
    @TableField("GRADE")
    private String  grade;


}
