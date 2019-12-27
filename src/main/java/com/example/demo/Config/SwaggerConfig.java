package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qianchen
 * @date 2019/12/26 14:43
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket petApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        // 指定提供接口所在的包
        .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
        .build();
  }

  /**
   * API 说明，包含作者、简介、版本、host、服务URL
   *
   * @return
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("学生表接口说明").version("1.0").description("demo Api").build();
  }
}
