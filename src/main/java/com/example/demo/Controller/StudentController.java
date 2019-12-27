package com.example.demo.Controller;

import com.example.demo.Exception.Response;
import com.example.demo.Input.getmessageInout;
import com.example.demo.Output.getmessageOutput;
import com.example.demo.Service.StudentService;
import com.example.demo.Input.createInout;
import com.example.demo.Output.createOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianchen
 * @date 2019/12/26 14:19
 */
@RestController
@RequestMapping("/student")
@Api(tags = {"学生管理"})
public class StudentController {

  @Autowired private StudentService studentService;

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ApiOperation(value = "新增学生信息", notes = "新增学生信息")
  public Response<createOutput> create(@RequestBody @Validated createInout request) {
    createOutput result = studentService.create(request);
    Response response = new Response();
    response.setData(result);
    return response;
  }


  @RequestMapping(value = "/getmessage",method = RequestMethod.POST)
  @ApiOperation(value = "根据学号获得学生信息", notes = "根据学号获得学生信息")
  public Response<getmessageOutput> getmessage(@RequestBody @Validated getmessageInout request) {
    getmessageOutput result = studentService.getmessage(request);
    Response response = new Response();
    response.setData(result);
    return response;
  }

}
