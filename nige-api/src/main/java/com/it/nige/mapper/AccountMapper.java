package com.it.nige.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.it.nige.entities.Account;
import com.it.nige.entities.Letter;

@Repository("accountMapper")
public class AccountMapper extends AbstractMapper {

	private static final Logger LOG = LoggerFactory.getLogger(AccountMapper.class);
	/**
	 * 회원가입
	 * 
	 * @param ac
	 * @return 성공시 1 실패시 0
	 */
	public Object setAccount(Account ac){
		return insert("account.insertAccount", ac);
	}
	
	/**
	 * 로그인
	 * 
	 * @param userId
	 * @return userId와 일치하는 Account객체 없을시 null
	 */
	public Account getAccountByUserId(String userId) {
		return (Account) selectOne("account.getAccountByUserId", userId);
	}
	
	/**
	 * 감사편지남기기
	 * 
	 * @param letter
	 * @return 성공 1 실패 0
	 */
	public Object setLetter(Letter letter) {
		return insert("account.setLetter", letter);
	}
}
