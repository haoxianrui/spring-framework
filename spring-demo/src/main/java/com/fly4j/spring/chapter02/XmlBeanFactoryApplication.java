package com.fly4j.spring.chapter02;

import com.fly4j.spring.chapter02.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class XmlBeanFactoryApplication {
	public static void main(String[] args) {
		ClassPathResource classPathResource = new ClassPathResource("spring-config.xml");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
		IUserService iUserService = (IUserService)xmlBeanFactory.getBean("userService");
		log.info(iUserService.getUsername());
	}
}
