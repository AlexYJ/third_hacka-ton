package com.it.nige.controllers;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.nige.annotations.API;
import com.it.nige.annotations.API.Useage;
import com.it.nige.annotations.AccessRole;
import com.it.nige.annotations.AccessRole.Role;
import com.it.nige.entities.Account;
import com.it.nige.services.AccountService;
/**
 * 사용자 계정에 관한 컨트롤러
 * 
 * @author geine
 * @since 1.0
 */
@RestController
public class AccountController extends AbstractController {

	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	@Resource(name = "accountService")
	private AccountService accountService;
	/**
	 * 회원가입
	 * 
	 * 인자 유효성 검사는 생략한다. nightingale 인자값에 주의할것
	 * @see com.it.nige.enums.Nightingale
	 * @param ac
	 * @date 2016.07.19
	 */
	@API(Useage.Experimental)
	@AccessRole(Role.All)
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public void setAccount(HttpServletRequest req, HttpServletResponse res, @RequestBody Account ac) {
		Map result = accountService.setAccount(req, res, ac);
		sendResponse(result, res);
	}
}
