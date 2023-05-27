package com.jw.controller;


import com.jw.entity.Student;
import com.jw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public Response getAll(){
        List<Student> list = studentService.list();
        return Response.buildSuccess(list);
    }

}
