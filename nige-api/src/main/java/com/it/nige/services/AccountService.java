package com.it.nige.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.it.nige.entities.Account;
import com.it.nige.enums.Error;
import com.it.nige.mapper.AccountMapper;

@Service("accountService")
public class AccountService {

	private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);
	
	@Resource(name = "accountMapper")
	private AccountMapper accountMapper;
	/**
	 * 회원가입
	 * 
	 * @param ac
	 * @return 업데이트 결과 HashMap
	 */
	public Map setAccount(HttpServletRequest req, HttpServletResponse res, Account ac){
		Object result = accountMapper.setAccount(ac);
		Map resultMap = new HashMap<String, Object>();

		if (result.equals(1)) {
			resultMap.put("code", Error.SUCCESS.getCode());
			resultMap.put("message", Error.SUCCESS.getMessage());
			resultMap.put("statusCode", Error.SUCCESS.getStatusCode());
		} else {
			resultMap.put("code", Error.DATABASE_UPDATE_FAIL.getCode());
			resultMap.put("message", Error.DATABASE_UPDATE_FAIL.getMessage());
			resultMap.put("statusCode", Error.DATABASE_UPDATE_FAIL.getStatusCode());
		}
		return resultMap;
	}
}
