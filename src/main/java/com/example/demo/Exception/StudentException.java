package com.example.demo.Exception;

/**
 * @author qianchen
 * @date 2019/12/26 14:59
 */
public class StudentException extends RuntimeException {
  private static final long serialVersionUID = -6370612186038915645L;
  private final ErrorCodeAndMsg response;

  public StudentException(ErrorCodeAndMsg response) {
    this.response = response;
  }

  public ErrorCodeAndMsg getResponse() {
    return response;
  }
}
