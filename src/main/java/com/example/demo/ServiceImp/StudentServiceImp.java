package com.example.demo.ServiceImp;

import com.example.demo.DO.CourseDO;
import com.example.demo.DO.ScDO;
import com.example.demo.Exception.ErrorCodeAndMsg;
import com.example.demo.Exception.StudentException;
import com.example.demo.Input.getMessageInout;
import com.example.demo.Output.getMessageOutput;
import com.example.demo.Service.StudentService;
import com.example.demo.Input.createInout;
import com.example.demo.Output.createOutput;
import com.example.demo.Utils.checkUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.DAO.StudentMapper;
import com.example.demo.DO.StudentDO;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author qianchen
 * @date 2019/12/26 11:52
 */
@Service
@Slf4j
@Api(tags = "学生信息操作接口")
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImp implements StudentService {

  @Resource StudentMapper studentMapper;

  @Override
  @ApiOperation(httpMethod = "POST", value = "新增学生信息接口")
  public createOutput create(createInout request) {
    StudentDO student = studentMapper.selectByPrimaryKey(request.getSno());
    if (student != null) {
      throw new StudentException(ErrorCodeAndMsg.student_is_exist);
    }
    /** 入参格式校验 */

    // 年龄校验
    if (request.getSage() != null) {
      if (!checkUtils.AgeValid(request.getSage())) {
        throw new StudentException(ErrorCodeAndMsg.age_is_error);
      }
    }
    // 姓名校验
    if (checkUtils.NameValid(request.getSname())) {
      throw new StudentException(ErrorCodeAndMsg.name_is_error);
    }
    // 性别校验
    if (!checkUtils.SexValid(request.getSex())) {
      throw new StudentException(ErrorCodeAndMsg.sex_is_error);
    }
    // 班级校验
    if (request.getSdept() != null) {
      if (checkUtils.NameValid(request.getSdept())) {
        throw new StudentException(ErrorCodeAndMsg.dept_is_error);
      }
    }
    StudentDO student1 = new StudentDO();
    student1.setSno(request.getSno());
    student1.setSname(request.getSname());
    student1.setSage(request.getSage());
    student1.setSex(request.getSex());
    student1.setSdept(request.getSdept());
    student1.setSdate(new Date());

    studentMapper.insert(student1);

    createOutput result = new createOutput();
    result.setSno(student1.getSno());
    result.setSdate(student1.getSdate());

    return result;
  }

  @Override
  public getMessageOutput getMessage(getMessageInout request) {
    getMessageOutput result = new getMessageOutput();
    Map<String, String> map = new HashMap<>();
    StudentDO studentDO = studentMapper.selectByPrimaryKey(request.getSno());
    if (studentDO == null) {
      throw new StudentException(ErrorCodeAndMsg.student_number_does_not_exist);
    }
    List<ScDO> scDOS = studentMapper.findscoreById(request.getSno());
    Map<String, String> map1 = new HashMap<>();
    Map<String, String> map2 = new HashMap<>();
    List<String> cnos = new ArrayList<>();
    // 建立课程号与课程成绩的map2
    for (ScDO sc : scDOS) {
      map2.put(sc.getCno(), sc.getScore());
      cnos.add(sc.getCno());
    }
    List<CourseDO> courseDOS = studentMapper.findcourseByIds(cnos);
    // 建立课程号与课程名称的map1
    for (CourseDO courseDO : courseDOS) {
      for (String cno : cnos) {
        if (cno.equals(courseDO.getCno())) {
          map1.put(cno, courseDO.getCname());
        }
      }
    }
    for (String cno : cnos) {
      map.put(map1.get(cno), map2.get(cno));
    }
    result.setMap(map);
    return result;
  }
}
