package com.jw.exception;


import com.jw.controller.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.jw.controller"})
@ResponseBody
public class MyServiceExceptionHandler {

    @ExceptionHandler(MyServiceException.class)
    private Response handleMyServiceException(MyServiceException e) {
        return new Response(e.getCode(), e.getMessage());
    }

}
