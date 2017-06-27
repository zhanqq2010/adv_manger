package com.adv.manager.factory;

import org.apache.ibatis.session.SqlSessionFactory;

public class sqlSessionFactoryUtil {
	public static SqlSessionFactory getSqlSessionFactory() {
		return (SqlSessionFactory) SpringContext.getContext().getBean("sqlSessionFactory");
	}
}
