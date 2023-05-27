package com.jw.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.jw.entity.Course;


import java.util.List;


public interface CourseService extends IService<Course> {
    List<Course> getAll();

    List<Course> getPersonalCourses(String username);

    void chooseCourse(String username, String courseId);

    String getAllInXML();

    List<Course> getOthers();

    void unchooseCourse(String username, String courseId);

    void chooseOtherCourse(String username, String courseId);

}
