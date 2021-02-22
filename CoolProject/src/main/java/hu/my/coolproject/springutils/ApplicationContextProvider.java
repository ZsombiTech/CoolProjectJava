package hu.my.coolproject.springutils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(" beallitva :) ");
		this.applicationContext = applicationContext;
	}

	public static Object getBeanByName(String beanName) {
		if (applicationContext.containsBean(beanName)) {
			return applicationContext.getBean(beanName);
		}
		return null;
	}
}
