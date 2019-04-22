package com.zxa.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * @ClassName: JsonUtils
 * @Description: //Json
 * @Author: zhangxin_an
 * @CreateDate: 2019/4/22 18:02
 */
public class JsonUtils {

	private static final Logger LOGGER = Logger.getLogger(JsonUtils.class);

	private static final ObjectMapper OBJECT_MAPPER =new ObjectMapper();

	public static <T> String toJson(T obj){
		String json;
		try {
			json = OBJECT_MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOGGER.error(String.format("cast Object to JSON failer params :[%s]",obj.toString()), e);
			throw new RuntimeException(e);
		}
		return json;
	}
	/**
	 * 将JSON转为POJO
	 */
	public static <T> T fromJson(String json,Class<T> type){
		T pojo;
		try {
			pojo = OBJECT_MAPPER.readValue(json,type);
		} catch (IOException e) {
			LOGGER.error(String.format("cast Object to JSON failer params :[%s]",json), e);
			throw new RuntimeException(e);
		}
		return pojo;

	}

}
