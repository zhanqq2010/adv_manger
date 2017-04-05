package com.adv.manager.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CommonUtil {

	/**
	 * 产生项目id
	 * @return
	 */
	public static String createPid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	
	public static String getTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	
}
