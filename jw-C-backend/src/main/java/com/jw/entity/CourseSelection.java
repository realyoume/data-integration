package com.jw.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@TableName("course_selection")
public class CourseSelection {

    /**
     * 课程id
     */
    @TableField("Cno")
    private String courseId;

    /**
     * 学生id
     */
    @TableField("Sno")
    private String studentId;

    /**
     * 成绩
     */
    @TableField("Grd")
    private String  grade;


}
