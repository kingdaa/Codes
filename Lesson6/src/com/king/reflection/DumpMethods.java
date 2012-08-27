package com.king.reflection;

import java.lang.reflect.Method;

public class DumpMethods
{
	public static void main(String[] args) throws Exception
	{
		Class<?> classType= Class.forName("java.lang.String");
		
		Method[] methods= classType.getDeclaredMethods();
		
		for(Method method : methods)
		{
			System.out.println(method);
		}
		
		
	}

}
