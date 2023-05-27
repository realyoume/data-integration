package com.jw.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@TableName("ROOT.STUDENT")
public class Student {

    /**
     * 学生id
     */
    @TableId("SNO")
    private String id;

    /**
     * 姓名
     */
    @TableField("SNAME")
    private String name;

    /**
     * 性别
     */
    @TableField("SSEX")
    private String  gender;

    /**
     * 院系
     */
    @TableField("SDEP")
    private String  department;

    /**
     * 密码
     */
    @TableField("SPWD")
    private String  username;



}
