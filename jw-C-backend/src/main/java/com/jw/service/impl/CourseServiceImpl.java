package com.jw.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jw.controller.Response;
import com.jw.entity.*;

import com.jw.mapper.CourseMapper;

import com.jw.service.CourseSelectionService;
import com.jw.service.CourseService;

import com.jw.service.StudentService;
import com.jw.util.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {


    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseSelectionService courseSelectionService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mypath.integrate}")
    private String integrateUrl;

    @Override
    public List<Course> getAll() {
        QueryWrapper<Course> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("Share", "0");

        return this.list(wrapper1);
    }

    @Override
    public String getAllInXML() {
        QueryWrapper<Course> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("Share", "0");

        List<Course> list = this.list(wrapper1);

        CourseList courseList = new CourseList(list);

        String xml = XMLUtil.Object2xml(courseList);

        return xml;
    }

    @Override
    public List<Course> getOthers() {
        Response response = restTemplate.getForObject(integrateUrl, Response.class);

        Object result = response.getResult();
        JSONArray jsonArray = (JSONArray) result;

        List<Course> courses = JSONObject.parseArray(jsonArray.toJSONString() , Course.class);

        return courses;
    }


    @Override
    public List<Course> getPersonalCourses(String username) {
        QueryWrapper<Student> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("acc", username);

        String studentId = studentService.getOne(wrapper1).getId();

        QueryWrapper<CourseSelection> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("Sno", studentId);

        List<CourseSelection> list = courseSelectionService.list(wrapper2);

        List<Course> ans = new ArrayList<>();
        for (CourseSelection selection : list) {
            QueryWrapper<Course> wrapper3 = new QueryWrapper<>();
            wrapper3.eq("Cno", selection.getCourseId());

            Course course = this.getOne(wrapper3);
            if (course != null){
                ans.add(course);
            }
        }

        return ans;
    }

    @Override
    public void chooseCourse(String username, String courseId) {
        QueryWrapper<Student> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("acc", username);

        String studentId = studentService.getOne(wrapper1).getId();

        CourseSelection courseSelection = CourseSelection.builder()
                .courseId(courseId)
                .studentId(studentId)
                .build();

        courseSelectionService.save(courseSelection);
    }

    @Override
    public void unchooseCourse(String username, String courseId) {
        QueryWrapper<Student> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("acc", username);

        String studentId = studentService.getOne(wrapper1).getId();

        QueryWrapper<CourseSelection> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("Cno", courseId).eq("Sno", studentId);

        courseSelectionService.remove(wrapper2);
    }

    @Override
    public void chooseOtherCourse(String username, String courseId) {
        QueryWrapper<Student> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("acc", username);

        String studentId = studentService.getOne(wrapper1).getId();

        CourseSelection courseSelection = CourseSelection.builder()
                .courseId(courseId)
                .studentId(studentId)
                .build();

        courseSelectionService.save(courseSelection);

        addOtherCourse(courseId);
    }

    public void addOtherCourse(String courseId){
        List<Course> list = this.list();
        for (Course course : list) {
            if (course.getId().equals(courseId)){
                return;
            }
        }

        List<Course> courses = this.getOthers();

        for (Course cours : courses) {
            if (cours.getId().equals(courseId)){
                cours.setShare("1");
                this.save(cours);
                return;
            }
        }

        return;
    }


}
