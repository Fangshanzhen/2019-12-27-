package com.example.demo.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qianchen
 * @date 2019/12/26 15:00
 */
@ControllerAdvice
@Slf4j
/**
 * 全局异常处理
 */
public class ExceptionHandler {
  @org.springframework.web.bind.annotation.ExceptionHandler(StudentException.class)
  @ResponseBody
  public Response handleStudentException(HttpServletRequest request, StudentException ex) {
    Response response;
    log.error(
        "StudentException code:{},msg:{}", ex.getResponse().getCode(), ex.getResponse().getMsg());
    response = new Response(ex.getResponse().getCode(), ex.getResponse().getMsg());
    return response;
  }

//  @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//  @ResponseBody
//  public Exception handleException(HttpServletRequest request, Exception ex) {
//    Exception response;
//    log.error("exception error:{}", ex);
//    response =
//        new Exception(
//            ErrorCodeAndMsg.Network_error.getCode(), ErrorCodeAndMsg.Network_error.getMsg());
//    return response;
//  }
}
