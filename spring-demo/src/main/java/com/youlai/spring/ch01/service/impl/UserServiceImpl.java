package com.youlai.spring.ch01.service.impl;

import com.youlai.spring.ch01.service.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class UserServiceImpl implements IUserService {
	public UserServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " 构造函数执行...");
	}
}
