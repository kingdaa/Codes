package com.shengsiyuan.annotation;

import java.text.DateFormat;
import java.util.Date;

public class DeprecatedTest
{
	@Deprecated
	public void doSomething()
	{
		System.out.println("do something!");
	}
	
	public static void main(String[] args)
	{
		DeprecatedTest test = new DeprecatedTest();
		
		test.doSomething();
		
		Date date=new Date();
		System.out.println(DateFormat.getDateInstance().format(date));
		
		
		
		
		
		
//		Date date = new Date();
//		
//		System.out.println(date.toLocaleString());
	}
}
