package com.youlai.spring.circularreference;

import com.youlai.spring.circularreference.config.ContextConfig;
import com.youlai.spring.circularreference.service.IServiceA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularReferenceApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ContextConfig.class
		);
		IServiceA serviceA = context.getBean(IServiceA.class);
		serviceA.m1();
	}
}
