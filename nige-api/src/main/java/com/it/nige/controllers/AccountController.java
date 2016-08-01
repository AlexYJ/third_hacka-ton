package com.it.nige.controllers;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.nige.annotations.API;
import com.it.nige.annotations.API.Useage;
import com.it.nige.annotations.AccessRole;
import com.it.nige.annotations.AccessRole.Role;
import com.it.nige.entities.Account;
import com.it.nige.entities.Letter;
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
	
	/**
	 * 로그인
	 * 
	 * @param Account ac ( userId, password )
	 * @date 2016.07.21
	 */
	@API(Useage.Experimental)
	@AccessRole(Role.All)
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public void doLogin(HttpServletRequest req, HttpServletResponse res, @RequestBody Account ac) {
		Map result = accountService.doLogin(req, res, ac);
		sendResponse(result, res);
	}
	
	/**
	 * 감사편지 남기기
	 * 
	 * @param Letter letter
	 * @param receiveSeqAccount 받는 계정 고유번호
	 * @date 2016.08.02
	 */
	@API(Useage.Experimental)
	@AccessRole(Role.Author)
	@RequestMapping(value = "/users/{receive_seqAccount}/letters", method = RequestMethod.POST)
	public void setLetter(HttpServletRequest req, HttpServletResponse res, @PathVariable("receive_seqAccount") double seqAccount, @RequestBody Letter letter){
		Map result = accountService.setLetter(req, res, seqAccount, letter);
		sendResponse(result, res);
	}
}
