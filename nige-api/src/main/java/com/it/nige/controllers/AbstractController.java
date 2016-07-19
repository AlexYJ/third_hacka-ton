package com.it.nige.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcp.chr.entities.Errors;

/**
 *  AbstractController
 * 
 *  컨트롤러의 공통 속성을 묶어놓은 추상클래스
 *  @date 2016.07.17
 *  @author genie
 *  @sicne 1.0
 */
public class AbstractController {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractController.class);
	
	/**
	 *  객체를 받아서 json 문자열로 변환한 뒤 응답한다.
	 *  cross-domain을 처리한다.
	 */
	public void sendResponse(Object res, HttpServletResponse response) {
		String json = new String();

		try {
			json = new ObjectMapper().writeValueAsString(res);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			LOG.error("json parse error");
			LOG.error(e.getStackTrace().toString());
		}
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error(e.getStackTrace().toString());
		}
	}
}
