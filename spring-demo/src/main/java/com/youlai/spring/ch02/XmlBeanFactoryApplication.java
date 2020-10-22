package com.youlai.spring.ch02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class XmlBeanFactoryApplication {
	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("spring-config.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);

		beanFactory.getBean("userService");
	}
}
