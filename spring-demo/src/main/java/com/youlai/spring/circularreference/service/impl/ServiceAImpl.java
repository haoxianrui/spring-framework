package com.youlai.spring.circularreference.service.impl;

import com.youlai.spring.circularreference.service.IServiceA;
import com.youlai.spring.circularreference.service.IServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ServiceAImpl implements IServiceA {

	@Autowired
	private IServiceB iServiceB;

	@Override

	public void m1() {
		iServiceB.m1();
	}
}
