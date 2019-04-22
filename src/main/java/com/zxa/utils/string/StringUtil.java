package com.zxa.utils.string;

/**
 * @ClassName: StringUtil
 * @Description: //字符串工具类
 * @Author: zhangxin_an
 * @CreateDate: 2019/4/22 17:33
 */
public class StringUtil {

	public static boolean isEmpty(String str){
		return str ==null || str.trim().length() == 0;
	}

	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}

}
