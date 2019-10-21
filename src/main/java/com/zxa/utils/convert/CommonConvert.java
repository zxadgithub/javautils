package com.zxa.utils.convert;

import com.zxa.utils.collection.CollectionUtil;
import com.zxa.utils.pojo.User;
import com.zxa.utils.pojo.UserVo;
import net.sf.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname CommonConvert
 * @Description 转换
 * @Date 2019/10/21 5:37 下午
 * @Created by zhangxinan
 */
public class CommonConvert {

	public static <T> List<T> convertList(List source, Class<T> target) throws Exception {
		if (CollectionUtil.isEmpty(source)) {
			return null;
		}
		BeanCopier beanCopier = BeanCopier.create(source.get(0).getClass(), target, false);
		return (List<T>) source.stream().map(s -> {
			T result = null;
			try {
				result = target.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			beanCopier.copy(s, result, null);
			return result;
		}).collect(Collectors.toList());
	}

	public static <T> T convert(Object source, Class<T> target) {
		try {
			T result = target.newInstance();
			BeanCopier beanCopier = BeanCopier.create(source.getClass(), target, false);
			beanCopier.copy(source, result, null);
			return result;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		List list = new ArrayList();

		User user = new User();
		user.setName("zxa");
		user.setAge(18);
		list.add(user);
		List<UserVo> convert = convertList(list, UserVo.class);
		System.out.println(convert);
	}

}
