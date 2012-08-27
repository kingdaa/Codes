package com.shengsiyuan.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnnotationTest(value2 = EnumTest.Welcome)
public class AnnotationUsage
{
	@AnnotationTest(value1 = { "world", "ABCD" },
			value2 = EnumTest.World)
	
	public void method()
	{
		System.out.println("usage of annotation");
	}
	public static void main(String[] args)
	{
		AnnotationUsage usage = new AnnotationUsage();

		usage.method();
	}
}
