package com.jw.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CourseSelection {

    /**
     * 课程id
     */
    @TableField("课程编号")
    private String courseId;

    /**
     * 学生id
     */
    @TableField("学生编号")
    private String studentId;

    /**
     * 成绩
     */
    @TableField("成绩")
    private String  grade;


}
