package com.adv.manager.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 
* @ClassName: SpringContext 
* @Description: TODO(这里用一句话描述这个类的作用)  此类可以取得Spring的上下文.
* @author zhanqq zhanqq2010@163.com 
* @date 2017年6月28日 上午2:58:53 
*
 */
public class SpringContext implements ApplicationContextAware {

	 protected static ApplicationContext context;
	    
	    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	        context = applicationContext;
	    }

	    public static ApplicationContext getContext() {
	        return context;
	    }

}
