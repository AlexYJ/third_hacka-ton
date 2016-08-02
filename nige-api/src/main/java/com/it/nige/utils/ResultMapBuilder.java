package com.it.nige.utils;

import java.util.HashMap;
import com.it.nige.enums.Error;
/**
 * ResultMapBuilder
 * Error enums를 인자로 받아 json 응답을 위한 hashmap 으로 반환한다.
 * enum 이름을 error로 지은게 후회스럽다..
 * 
 * @author genie
 * @date 2016.08.02
 */
public class ResultMapBuilder {

	private volatile static ResultMapBuilder instance;
	private volatile static HashMap<String,Object> resultMap = new HashMap<String,Object>();
	private ResultMapBuilder() {}; //기본 생성자 제거
	
	/**
	 * Singleton
	 * 
	 * @return instance
	 */
	public static synchronized ResultMapBuilder getInstance() {
		
		if(instance == null) {
			instance = new ResultMapBuilder();
		}
		
		return instance;
	}
	/**
	 * error enum을 hashmap 으로 파싱한다.
	 * 
	 * @param error
	 * @return hashmap
	 */
	public static synchronized HashMap<String, Object> setResult(Error error) {
		
		resultMap.put("code", error.getCode());
		resultMap.put("message", error.getMessage());
		resultMap.put("statusCode", error.getStatusCode());
		
		return resultMap;
	}
}
