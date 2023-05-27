package com.jw.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@Builder
@TableName("ROOT.COURSE")
@XmlRootElement(name = "course")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    /**
     * 课程id
     */
    @TableId("ID")
    @XmlElement(name = "编号")
    private String id;

    /**
     * 名称
     */
    @TableField("NAME")
    @XmlElement(name = "名称")
    private String name;

    /**
     * 课时
     */
    @TableField("TIME")
    @XmlElement(name = "课时")
    private String time;

    /**
     * 学分
     */
    @TableField("SCORE")
    @XmlElement(name = "学分")
    private String  credit;

    /**
     * 教师
     */
    @TableField("TEACHER")
    @XmlElement(name = "老师")
    private String  teacher;

    /**
     * 地点
     */
    @TableField("LOCATION")
    @XmlElement(name = "地点")
    private String  position;

    /**
     * 是否共享
     */
    @TableField("SHARE_")
    @XmlElement(name = "共享")
    private String  share;

}
