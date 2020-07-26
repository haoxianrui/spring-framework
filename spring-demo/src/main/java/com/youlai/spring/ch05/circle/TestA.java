package com.youlai.spring.ch05.circle;

public class TestA {

	private TestB testB;

	public void a() {
		testB.b();
	}

	public TestB getTestB() {
		return testB;
	}

	public void setTestB(TestB testB) {
		this.testB = testB;
	}
}
