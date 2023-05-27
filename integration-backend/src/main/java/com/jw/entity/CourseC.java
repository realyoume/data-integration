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
@XmlRootElement(name = "course")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class CourseC {

    /**
     * 课程id
     */
    @XmlElement(name = "Cno")
    private String id;

    /**
     * 名称
     */
    @XmlElement(name = "Cnm")
    private String name;

    /**
     * 学分
     */
    @XmlElement(name = "Cpt")
    private String  credit;

    /**
     * 教师
     */
    @XmlElement(name = "Tec")
    private String  teacher;

    /**
     * 地点
     */
    @XmlElement(name = "Pla")
    private String  position;

    /**
     * 是否共享
     */
    @XmlElement(name = "Share")
    private String  share;

}
