package com.jw.service;



import com.jw.entity.CourseA;
import com.jw.entity.CourseB;
import com.jw.entity.CourseC;

import java.io.IOException;
import java.util.List;


public interface CourseService{
    List<CourseA> getAOthers() throws IOException;

    List<CourseB> getBOthers() throws IOException;

    List<CourseC> getCOthers() throws IOException;


}
