package com.jw.entity;

import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "courseList")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class CourseList {

    @XmlElement(name = "course")
    List<Course> courses;

    public CourseList(List<Course> courses) {
        this.courses = courses;
    }
}
