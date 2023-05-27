package com.jw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jw.entity.CourseSelection;

import java.util.List;


public interface CourseSelectionService extends IService<CourseSelection> {

    List<CourseSelection> getScoresById(String id);

    void updateScore(CourseSelection courseSelection);

}
