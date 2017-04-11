package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 加载application.properties文件内容
 * */
@Component
@ConfigurationProperties(prefix="server")
@PropertySource("classpath:application.properties")
public class LoadProperties {
	
	private String port;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
}
