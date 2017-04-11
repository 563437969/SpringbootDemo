package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	 @Bean
	    public Docket createRestApi() {
		 return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("test")
	                .genericModelSubstitutes(DeferredResult.class)
	                .useDefaultResponseMessages(false)
	                .forCodeGeneration(true)
	                .pathMapping("/")//api请求地址
	                .select()
	                .paths(PathSelectors.regex("/api/.*"))//过滤的接口
	                .build()
	                .apiInfo(apiInfo());
	    }

	    private ApiInfo apiInfo() {
	    	 System.out.println("/swagger-ui.html");
	    	 Contact contact = new Contact("小强", "http://xxx.com", "563437969@qq.com");
	         ApiInfo apiInfo = new ApiInfo("某API接口",//大标题
	                 "REST风格API",//小标题
	                 "0.1",//版本
	                 "www.baidu.com",
	                 contact,//作者
	                 "主页",//链接显示文字
	                 "www.xiaoqiang.com"//网站链接
	         );
	         return apiInfo;
	    }

}
