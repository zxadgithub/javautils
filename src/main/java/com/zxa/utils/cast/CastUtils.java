package com.zxa.utils.cast;

import com.zxa.utils.string.StringUtil;
import org.apache.log4j.Logger;

/**
 * @ClassName: CastUtils
 * @Description: //数据类型转换
 * @Author: zhangxin_an
 * @CreateDate: 2019/4/22 17:39
 */
public class CastUtils {

	private static final Logger LOGGER = Logger.getLogger(CastUtils.class);

	public static String castString(Object o){
		return CastUtils.castString(o, "");
	}

	public static String castString(Object obj, String defaultValue){
		return obj != null ? String.valueOf(obj) : defaultValue;
	}

	/**
	 * 转为Double类型，如果为null或者空字符串或者格式不对则返回0
	 * @param obj
	 * @param defaultValue
	 * @return
	 * @throws NumberFormatException
	 */
	public static Double castDouble(Object obj, Double defaultValue){
		Double value = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)){
				try {
					value = Double.parseDouble(strValue);
				} catch (NumberFormatException e) {
					value = defaultValue;
					LOGGER.error(String.format("cast Double error params:[%s]", obj.toString()), e);
				}
			}
		}
		return value;
	}
	public static Double castDouble(Object obj){
		return castDouble(obj, new Double(0));
	}
	/**
	 * 转为Integer类型，如果为null或者空字符串或者格式不对则返回0
	 * @param obj
	 * @param defaultValue
	 * @return
	 * @throws NumberFormatException
	 */
	public static Integer castInteger(Object obj, Integer defaultValue){
		Integer value = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)){
				try {
					value = Integer.valueOf(strValue);
				} catch (NumberFormatException e) {
					value = defaultValue;
					LOGGER.error(String.format("cast Integer error params:[%s]", obj.toString()),e);
				}
			}
		}
		return value;
	}
	public static Integer castInteger(Object obj){
		return castInteger(obj, new Integer(0));
	}

}
