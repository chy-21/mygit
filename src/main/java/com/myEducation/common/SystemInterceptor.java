package com.myEducation.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.myEducation.inside.utils.Constant;


public class SystemInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 后台session控制
		String[] noFilters = new String[] {};
		String uri = request.getRequestURI();

		boolean beFilter = false;
		for (String s : noFilters) {
			if (uri.indexOf(s) != -1) {
				beFilter = false;
				break;
			}
		}
		if (beFilter) {
			Object obj = request.getSession().getAttribute(Constant.LOGIN_USER);
			if (null == obj) {
				// 未登录
				response.sendRedirect(request.getContextPath() + "/login");
				return false;
			}
		}

		return super.preHandle(request, response, handler);
	}
}
