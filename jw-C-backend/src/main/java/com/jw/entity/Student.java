package com.jw.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@TableName("dbo.student")
public class Student {

    /**
     * 学生id
     */
    @TableId("Sno")
    private String id;

    /**
     * 姓名
     */
    @TableField("Snm")
    private String name;

    /**
     * 性别
     */
    @TableField("Sex")
    private String  gender;

    /**
     * 院系
     */
    @TableField("Sde")
    private String  department;

    /**
     * 用户名
     */
    @TableField("acc")
    private String  username;

}
