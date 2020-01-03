package com.example.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.charset.Charset;
import java.util.Arrays;

@EnableSwagger2
@EnableCaching
@SpringBootApplication
@MapperScan("com.example.demo.DAO")
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  /**
   * springboot 使用fastjson序列化
   * @return
   */
  @Bean
  public HttpMessageConverters fastJsonHttpMessageConverters() {
    // 1、定义一个convert转换消息的对象
    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
    // 2、添加fastjson的配置信息
    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
    fastConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
    // 3、在convert中添加配置信息
    fastConverter.setFastJsonConfig(fastJsonConfig);
    // 4、将convert添加到converters中
    HttpMessageConverter<?> converter = fastConverter;
    // 5、日期格式化
    fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
    return new HttpMessageConverters(
        fastConverter, new StringHttpMessageConverter(Charset.forName("UTF-8")));
  }
}
