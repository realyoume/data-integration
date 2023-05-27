package com.jw.entity;



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
public class CourseB {

    /**
     * 课程id
     */
    @XmlElement(name = "编号")
    private String id;

    /**
     * 名称
     */
    @XmlElement(name = "名称")
    private String name;

    /**
     * 课时
     */
    @XmlElement(name = "课时")
    private String time;

    /**
     * 学分
     */
    @XmlElement(name = "学分")
    private String  credit;

    /**
     * 教师
     */
    @XmlElement(name = "老师")
    private String  teacher;

    /**
     * 地点
     */
    @XmlElement(name = "地点")
    private String  position;

    /**
     * 是否共享
     */
    @XmlElement(name = "共享")
    private String  share;

}
