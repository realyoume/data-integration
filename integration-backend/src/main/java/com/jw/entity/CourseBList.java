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
public class CourseBList {

    @XmlElement(name = "course")
    public List<CourseB> courses;

    public CourseBList(List<CourseB> courses) {
        this.courses = courses;
    }
}
