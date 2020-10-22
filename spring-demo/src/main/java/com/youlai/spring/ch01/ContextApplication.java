package com.youlai.spring.ch01;

import com.youlai.spring.ch01.config.ContextConfig;
import com.youlai.spring.ch01.service.IUserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ContextApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ContextConfig.class
		);
		IUserService bean = context.getBean(IUserService.class);
		System.out.println(bean);
	}
}
