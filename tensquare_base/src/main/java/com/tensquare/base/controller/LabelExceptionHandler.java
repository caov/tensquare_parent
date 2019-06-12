package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: tensquare_parent
 * @description:
 * @author: cf
 * @create: 2019-06-12 10:34
 */
@RestControllerAdvice
public class LabelExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,  e.getMessage());
    }
}
