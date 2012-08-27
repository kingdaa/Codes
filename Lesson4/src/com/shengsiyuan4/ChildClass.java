package com.shengsiyuan4;

public class ChildClass<T1, T2> implements ParentInterface<T1, T2> {
	private T1 foo1;
	private T2 foo2;

	@Override
	public T1 getFoo1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T2 getFoo2() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFoo1(T1 foo1) {
		this.foo1=foo1;
	};

	public void setFoo2(T2 foo2) {
		this.foo2=foo2;
	};

}
