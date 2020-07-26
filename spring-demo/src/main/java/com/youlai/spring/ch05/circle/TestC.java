package com.youlai.spring.ch05.circle;

public class TestC {

	public void c (){
		testA.a();
	}

	private TestA testA;

	public TestA getTestA() {
		return testA;
	}

	public void setTestA(TestA testA) {
		this.testA = testA;
	}
}
