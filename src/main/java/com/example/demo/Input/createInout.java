package com.example.demo.Input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author qianchen
 * @date 2019/12/26 11:14
 */
@Getter
@Setter
@ApiModel(value = "入参")
public class createInout {
    @ApiModelProperty(value = "学号", required = true)
    @NotNull(message = "学号不能为空！")
    private Integer sno;

    @ApiModelProperty(value = "姓名", required = true)
    @NotBlank(message = "姓名不能为空！")
    private String sname;

    @ApiModelProperty(value = "性别", required = true)
    @NotBlank(message = "性别不能为空！")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private Integer sage;

    @Length(max = 30, message = "长度不能超过30个字符！")
    @ApiModelProperty(value = "班级")
    private String sdept;


}
