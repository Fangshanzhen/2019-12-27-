package com.example.demo.Output;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author qianchen
 * @date 2019/12/27 11:34
 */
@Data
public class getMessageOutput {
  @ApiModelProperty(value = "课程名称及成绩")
  private Map<String, String> map;
}
