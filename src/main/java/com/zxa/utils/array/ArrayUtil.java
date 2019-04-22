package com.zxa.utils.array;

/**
 * @ClassName: ArrayUtil
 * @Description: //数组判空
 * @Author: zhangxin_an
 * @CreateDate: 2019/4/22 18:01
 */
public class ArrayUtil {
	/**
	 * 判断数组是否为空
	 * @param array
	 * @return
	 */
	public static boolean isNotEmpty(Object[] array){
		return !isEmpty(array);
	}

	/**
	 * 判断数组是否非空
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array){
		return array==null||array.length==0;
	}
}
