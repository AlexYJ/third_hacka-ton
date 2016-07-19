package com.it.nige.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.it.nige.annotations.AccessRole;

public class AccessRoleResolver extends WebContentInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(AccessRoleResolver.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
		AccessRole anno = ((HandlerMethod)handler).getMethodAnnotation(AccessRole.class);
		return true;
	}
}
