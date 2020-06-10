package com.fly4j.spring.ch02.service.impl;

import com.fly4j.spring.ch02.service.IUserService;

public class UserServiceImpl implements IUserService {


	@Override
	public String getUsername() {
		return "张三";
	}
}
