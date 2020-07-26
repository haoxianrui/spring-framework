package com.youlai.spring.ch05.circle;

public class TestB {


	private TestC testC;


	public void b() {
		testC.c();
	}

	public TestC getTestC() {
		return testC;
	}

	public void setTestC(TestC testC) {
		this.testC = testC;
	}
}
