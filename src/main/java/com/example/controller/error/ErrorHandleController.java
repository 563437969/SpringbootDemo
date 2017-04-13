package com.example.controller.error;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jxq
 * 2017-03-22
 * 错误页面配置
 * */
@Controller
public class ErrorHandleController implements ErrorController{

	
	@Override
	public String getErrorPath() {
		return "error/404";
	}
	
	@RequestMapping("/error")
    public String errorHandle(Map<String,Object> map){
		map.put("msg",this.getErrorPath());
        return getErrorPath();
    }

}
