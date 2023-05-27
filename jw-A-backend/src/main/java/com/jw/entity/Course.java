package com.jw.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@XmlRootElement(name = "course")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    /**
     * 课程id
     */
    @TableId("课程编号")
    @XmlElement(name = "课程编号")
    private String id;

    /**
     * 名称
     */
    @TableField("课程名称")
    @XmlElement(name = "课程名称")
    private String name;

    /**
     * 学分
     */
    @TableField("学分")
    @XmlElement(name = "学分")
    private String  credit;

    /**
     * 教师
     */
    @TableField("授课老师")
    @XmlElement(name = "授课老师")
    private String  teacher;

    /**
     * 地点
     */
    @TableField("授课地点")
    @XmlElement(name = "授课地点")
    private String  position;

    /**
     * 是否共享
     */
    @TableField("共享")
    @XmlElement(name = "共享")
    private String  share;

}
