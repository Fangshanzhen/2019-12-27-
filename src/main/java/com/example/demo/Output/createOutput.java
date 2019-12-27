package com.example.demo.Output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qianchen
 * @date 2019/12/26 11:55
 */
@Data
@ApiModel(value = "新增用户出参")
public class createOutput {
    @ApiModelProperty(value = "Id")
    private Integer sno;

}
