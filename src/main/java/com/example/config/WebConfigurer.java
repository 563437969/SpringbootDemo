package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.controller.Interceptor.BaseInterceptor;
import com.example.controller.Interceptor.InterceptorAppend;

/**
 * Web配置类  当前作用为配置拦截器
 * */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
		registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/**")
		                                              .excludePathPatterns("/login*")
		                                              .excludePathPatterns("/error");
        registry.addInterceptor(new InterceptorAppend()).addPathPatterns("/**")
                                                        .excludePathPatterns("/login*")
                                                        .excludePathPatterns("/error");
		super.addInterceptors(registry);
	}

}
