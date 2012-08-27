package com.king.reflection;

import java.lang.Class;
import java.lang.String;
import java.lang.System;

public class ClassTest
{
	public static void main(String[] args)
	{
		Class<?> classType = Child.class;
		System.out.println(classType);
		classType = classType.getSuperclass();
		System.out.println(classType);
		classType = classType.getSuperclass();
		System.out.println(classType);
	}

}
class Parent
{
	
}
class Child extends Parent
{
	
}
