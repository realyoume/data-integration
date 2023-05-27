package com.jw.controller;

import com.jw.entity.CourseSelection;
import com.jw.entity.User;
import com.jw.service.CourseSelectionService;
import com.jw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private CourseSelectionService courseSelectionService;


    @GetMapping("/{id}")
    public Response getScoresById(@PathVariable("id") String id){
        List<CourseSelection> scores = courseSelectionService.getScoresById(id);
        return Response.buildSuccess(scores);
    }

    @PostMapping()
    public Response updateScore(@RequestBody CourseSelection courseSelection){
        courseSelectionService.updateScore(courseSelection);

        return Response.buildSuccess();
    }

}
