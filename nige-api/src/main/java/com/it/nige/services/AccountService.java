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
import com.it.nige.entities.Letter;
import com.it.nige.enums.Error;
import com.it.nige.mapper.AccountMapper;
import com.it.nige.utils.ResultMapBuilder;

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

		if(result.equals(1)){
			resultMap = ResultMapBuilder.getInstance().setResult(Error.SUCCESS);
		} else {
			resultMap = ResultMapBuilder.getInstance().setResult(Error.DATABASE_UPDATE_FAIL);
		}
		return resultMap;
	}
	
	/**
	 * 로그인
	 * @param ac
	 * @return 패스워드 일치 여부 결과 HashMap
	 */
	public Map doLogin(HttpServletRequest req, HttpServletResponse res, Account ac) {
		
		Account saveAccount = accountMapper.getAccountByUserId(ac.getUserId());
		Map resultMap = new HashMap<String, Object>();
		
		try {
		
			if (saveAccount.getPassword().equals(ac.getPassword())) {
				resultMap = ResultMapBuilder.getInstance().setResult(Error.SUCCESS);
				LOG.info("로그인 : {}",saveAccount.toString());
			} else {
				resultMap = ResultMapBuilder.getInstance().setResult(Error.PASSWORD_NOT_CORRECT);
				LOG.info("패스워드 불일치 : {} / {}", ac.getPassword(), saveAccount.getPassword());
			} 
		} catch (NullPointerException e) {
			resultMap = ResultMapBuilder.getInstance().setResult(Error.NOT_FOUND_USER);
			LOG.error("가입되지 않은 사용자 : {}", ac.getUserId());
		}
		return resultMap;
	}
	
	/**
	 * 감사편지 남기기
	 * 
	 * @param receiveSeqAccount 받는 계정 고유번호
	 * @param Letter letter
	 * @return 업데이트 결과 HashMap
	 */
	public Map setLetter(HttpServletRequest req, HttpServletResponse res, double receiveSeqAccount, Letter letter){
		Account ac = (Account) req.getSession().getAttribute("account");
		
		// 2016.08.02 예외처리 resultMapBuilder만들고 할래.. 넘나 귀찮은것
		letter.setReceiveSeqAccount(receiveSeqAccount);
		letter.setSeqAccount(ac.getSeqAccount());
		Object result = accountMapper.setLetter(letter);
		HashMap<String,Object> resultMap = new HashMap<String, Object>();
		if(result.equals(1)){
			resultMap = ResultMapBuilder.getInstance().setResult(Error.SUCCESS);
		} else {
			resultMap = ResultMapBuilder.getInstance().setResult(Error.DATABASE_UPDATE_FAIL);
		}
		return resultMap;
	}
}
