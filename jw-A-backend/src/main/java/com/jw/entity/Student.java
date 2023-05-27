package com.jw.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Student {

    /**
     * 学生id
     */
    @TableId("学号")
    private String id;

    /**
     * 姓名
     */
    @TableField("姓名")
    private String name;

    /**
     * 性别
     */
    @TableField("性别")
    private String  gender;

    /**
     * 院系
     */
    @TableField("院系")
    private String  department;

    /**
     * 用户名
     */
    @TableField("关联账户")
    private String  username;

}
