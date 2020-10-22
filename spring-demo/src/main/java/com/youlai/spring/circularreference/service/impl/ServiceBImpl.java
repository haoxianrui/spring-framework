package com.youlai.spring.circularreference.service.impl;

import com.youlai.spring.circularreference.service.IServiceA;
import com.youlai.spring.circularreference.service.IServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBImpl implements IServiceB {

	@Override
	@Transactional
	public void m1()  {
		System.out.println("ServiceBImpl#m1");
	}

}
