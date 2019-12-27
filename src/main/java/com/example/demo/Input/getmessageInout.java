package com.example.demo.Input;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author qianchen
 * @date 2019/12/27 11:32
 */
public class getmessageInout {
    @ApiModelProperty(value = "学号", required = true)
    @NotNull(message = "学号不能为空！")
    private Integer sno;
}
