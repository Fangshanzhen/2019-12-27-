package com.example.demo.Exception;

/**
 * @author qianchen
 * @date 2019/12/26 14:58
 * 异常枚举类
 */
public enum ErrorCodeAndMsg {
  student_number_does_not_exist("001", "学号不存在"),
  student_number_is_empty("003", "学号为空"),
  student_is_exist("004", "该学生已存在"),
  age_is_error("005", "年龄输入错误"),
  name_is_error("006", "姓名格式错误"),
  sex_is_error("007", "性别输入错误"),
  dept_is_error("008", "班级格式错误");
  private String code;
  private String msg;

  ErrorCodeAndMsg(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
