package com.jw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jw.entity.CourseSelection;
import com.jw.mapper.CourseSelectionMapper;
import com.jw.service.CourseSelectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectionServiceImpl extends ServiceImpl<CourseSelectionMapper, CourseSelection> implements CourseSelectionService {

    @Override
    public void updateScore(CourseSelection courseSelection) {
        QueryWrapper<CourseSelection> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("学生编号", courseSelection.getStudentId());
        wrapper1.eq("课程编号", courseSelection.getCourseId());

        this.update(courseSelection, wrapper1);
    }

    @Override
    public List<CourseSelection> getScoresById(String id) {
        QueryWrapper<CourseSelection> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("学生编号", id);

        List<CourseSelection> list = this.list(wrapper1);

        return list;
    }
}
