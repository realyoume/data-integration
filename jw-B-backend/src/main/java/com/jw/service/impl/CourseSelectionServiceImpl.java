package com.jw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jw.entity.CourseSelection;
import com.jw.entity.Student;
import com.jw.mapper.CourseSelectionMapper;
import com.jw.service.CourseSelectionService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseSelectionServiceImpl extends ServiceImpl<CourseSelectionMapper, CourseSelection> implements CourseSelectionService {

    @Override
    public void updateScore(CourseSelection courseSelection) {
        QueryWrapper<CourseSelection> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("SNO", courseSelection.getStudentId());
        wrapper1.eq("CNO", courseSelection.getCourseId());

        this.update(courseSelection, wrapper1);
    }

    @Override
    public List<CourseSelection> getScoresById(String id) {
        QueryWrapper<CourseSelection> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("SNO", id);

        List<CourseSelection> list = this.list(wrapper1);

        return list;
    }
}
