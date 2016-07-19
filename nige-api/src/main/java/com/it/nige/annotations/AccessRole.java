package com.it.nige.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author geine
 *
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface AccessRole {

	Role value();
	
	enum Role {
		
		/**
		 *  본인
		 */
		Author,
		
		/**
		 *  상관 없음
		 */
		All,
		
		/**
		 *  비 로그인 0,로그인 시 개인식별번호
		 */
		Selector
	}
}
