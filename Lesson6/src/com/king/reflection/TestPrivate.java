package com.king.reflection;

import java.lang.reflect.Method;

public class TestPrivate
{
	public static void main(String[] args) throws Exception
	{
		PrivateTest privateTest=new PrivateTest();
		Class<? extends PrivateTest> classType=privateTest.getClass();
		Method[] methods=classType.getDeclaredMethods();
//		for (Method method : methods)
//		{
//			System.out.println(method);
//		}
		//!!!set the private method in PrivateTest accessible
		methods[0].setAccessible(true);
		
		String str=(String)methods[0].invoke(privateTest, new Object[]{"Deming"});
		System.out.println(str);
		
		
		
		
	}

}
