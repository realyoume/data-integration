package com.jw.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jw.entity.Student;
import com.jw.mapper.StudentMapper;
import com.jw.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
