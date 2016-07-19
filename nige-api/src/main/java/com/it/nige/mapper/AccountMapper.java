package com.it.nige.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.it.nige.entities.Account;

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
	
}