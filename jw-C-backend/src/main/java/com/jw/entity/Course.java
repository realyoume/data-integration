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
@TableName("course")
@XmlRootElement(name = "course")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    /**
     * 课程id
     */
    @TableId("Cno")
    @XmlElement(name = "Cno")
    private String id;

    /**
     * 名称
     */
    @TableField("Cnm")
    @XmlElement(name = "Cnm")
    private String name;

    /**
     * 学分
     */
    @TableField("Cpt")
    @XmlElement(name = "Cpt")
    private String  credit;

    /**
     * 教师
     */
    @TableField("Tec")
    @XmlElement(name = "Tec")
    private String  teacher;

    /**
     * 地点
     */
    @TableField("Pla")
    @XmlElement(name = "Pla")
    private String  position;

    /**
     * 是否共享
     */
    @TableField("Share")
    @XmlElement(name = "Share")
    private String  share;

}
