package com.king.reflection;

import java.lang.reflect.Field;

public class TestPrivate2
{
	public static void main(String[] args) throws Exception
	{
		PrivateTest2 pt=new PrivateTest2();
		Class<?> ct=pt.getClass();
		Field field=ct.getDeclaredField("name");
		field.setAccessible(true);
		field.set(pt, "Deming");
		System.out.println(pt.getName());
		
		
		
	}

}
