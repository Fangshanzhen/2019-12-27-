package com.example.demo.Controller;

import com.example.demo.DO.ScDO;
import com.example.demo.DO.StudentDO;
import com.example.demo.Exception.Response;
import com.example.demo.Input.getMessageInout;
import com.example.demo.Output.getMessageOutput;
import com.example.demo.Service.StudentService;
import com.example.demo.Input.createInout;
import com.example.demo.Output.createOutput;
import com.example.demo.Utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author qianchen
 * @date 2019/12/26 14:19
 */
@RestController
@RequestMapping("/student")
@Api(tags = {"学生管理"})
public class StudentController {

  @Autowired private StudentService studentService;
  @Autowired private RedisUtil redis;

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ApiOperation(value = "新增学生信息", notes = "新增学生信息")
  public Response<createOutput> create(@RequestBody @Validated createInout request) {
    createOutput result = studentService.create(request);
    Response response = new Response();
    response.setData(result);
    return response;
  }

    /**
     * @Validated与 @Valid的区别
     */
  @RequestMapping(value = "/getMessage", method = RequestMethod.POST)
  @ApiOperation(value = "根据学号获得学生课程号及成绩", notes = "根据学号获得学生课程号及成绩")
  public Response<getMessageOutput> getMessage(@RequestBody @Valid getMessageInout request, BindingResult res) {
    getMessageOutput result = studentService.getMessage(request);
    Response response = new Response();
    response.setData(result);
//    if(res.hasErrors()){
//        List<ObjectError>errorList=res.getAllErrors();
//        List<String>resultList=new ArrayList<>();
//        for(ObjectError error:errorList){
//            resultList.add(error.getDefaultMessage());
//        }
//         response.setData(resultList);
//    }

    return response;
  }


}


