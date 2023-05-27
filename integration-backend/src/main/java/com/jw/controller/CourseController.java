package com.jw.controller;



import com.jw.entity.Course;
import com.jw.entity.CourseA;
import com.jw.entity.CourseB;
import com.jw.entity.CourseC;
import com.jw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


//    @GetMapping("/others")
//    public Response getOthers(){
//        List<Course> list = courseService.getOthers();
//        return Response.buildSuccess(list);
//    }

    @GetMapping("/a/others")
    public Response getAOthers() throws IOException {
        List<CourseA> list = courseService.getAOthers();
        return Response.buildSuccess(list);
    }

    @GetMapping("/b/others")
    public Response getBOthers() throws IOException {
        List<CourseB> list = courseService.getBOthers();
        return Response.buildSuccess(list);
    }

    @GetMapping("/c/others")
    public Response getCOthers() throws IOException {
        List<CourseC> list = courseService.getCOthers();
        return Response.buildSuccess(list);
    }





}
