package com.jw.controller;



import com.jw.entity.Course;
import com.jw.entity.Student;
import com.jw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/")
    public Response getAll(){
        List<Course> list = courseService.getAll();
        return Response.buildSuccess(list);
    }

    @GetMapping("/xml")
    public String getAllInXML(){
        return courseService.getAllInXML();
    }

    @PostMapping("/person")
    public Response getPerson(@RequestBody Student student){
        List<Course> list = courseService.getPersonalCourses(student.getUsername());
        return Response.buildSuccess(list);
    }

    @GetMapping("/others")
    public Response getOthers(){
        List<Course> list = courseService.getOthers();
        return Response.buildSuccess(list);
    }

    @PostMapping("/choose/{courseId}")
    public Response chooseCourse(@RequestBody Student student, @PathVariable String courseId){
        courseService.chooseCourse(student.getUsername(), courseId);
        return Response.buildSuccess();
    }


    @PostMapping("/unchoose/{courseId}")
    public Response unchooseCourse(@RequestBody Student student, @PathVariable String courseId){
        courseService.unchooseCourse(student.getUsername(), courseId);
        return Response.buildSuccess();
    }

    @PostMapping("/choose/other/{courseId}")
    public Response chooseOtherCourse(@RequestBody Student student, @PathVariable String courseId){
        courseService.chooseOtherCourse(student.getUsername(), courseId);
        return Response.buildSuccess();
    }
}
