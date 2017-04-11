package com.example.controller.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.util.ConstantUtil;

public class BaseInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		 //System.out.println(">>>BaseInterceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
		
		//进行登录判断
		Object userId = request.getSession().getAttribute(ConstantUtil.USERID);
		if(null == userId || "".equals(userId)){
			response.sendRedirect(request.getContextPath() + ConstantUtil.LOGIN);
			return false;
		}else{
			return true;
		}
		
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		//System.out.println(">>>BaseInterceptor>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//System.out.println(">>>BaseInterceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}
}
