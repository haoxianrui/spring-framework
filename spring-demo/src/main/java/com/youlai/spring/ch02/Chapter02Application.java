package com.youlai.spring.ch02;

import com.youlai.spring.ch02.service.IUserService;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Chapter02Application {
	public static void main(String[] args) {
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
		IUserService iUserService = (IUserService) xmlBeanFactory.getBean("userService");
	}
}
