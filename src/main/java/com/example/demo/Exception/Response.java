package com.example.demo.Exception;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * @author qianchen
 * @date 2019/12/26 14:54
 */
@Getter
@Setter
public class Response<T> implements Serializable {
  private static final long serialVersionUID = -4505655308965878999L;
  // 请求成功返回码为：000
  private static final String successCode = "000";
  // 返回数据
  private T data;
  // 返回码
  private String code;
  // 返回描述
  private String msg;

  public Response() {
    this.code = successCode;
    this.msg = "请求成功";
  }

  public Response(String code, String msg) {

    this();
    this.code = code;
    this.msg = msg;
  }

  public Response(String code, String msg, T data) {

    this();
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public Response(T data) {

    this();
    this.data = data;
  }
}
