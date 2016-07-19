/**
 * 
 */
package com.it.nige.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * API annotation
 * 
 * @date 2016.07.17
 * @author geine
 *
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface API {

	Useage value();
	
	enum Useage {
		
		/**
		 *  내부용
		 */
		Internal,
		
		/**
		 *  안정
		 */
		Stable,
		
		/**
		 *  사용중단
		 */
		Deprecated,
		
		/**
		 *  개발중
		 */
		Experimental
	}
}
