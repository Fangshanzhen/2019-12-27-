package com.example.demo.Input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author qianchen
 * @date 2019/12/27 11:32
 */
@Data
public class getMessageInout {
    @ApiModelProperty(value = "学号", required = true)
    @NotNull(message = "学号不能为空！")
    private Integer sno;
}
