package com.king.contest2;

import java.lang.reflect.Method;

public class ApplicationRun
{
	public void run(String className) throws Exception
	{
		Class<?> c = Class.forName(className);
//		Method m = c.getMethod("whizzy", int.class, int.class);  
		Object obj=c.newInstance();
		Method[] methods=c.getMethods();
		for(Method m:methods)
		{
			if(m.isAnnotationPresent(Test.class))
			{
				Class<?>[] paraarr=m.getParameterTypes();
				//Only run the methods which don't have any parameter
				if(paraarr.length==0)
				{
					m.invoke(obj, new Object[] {});
				}
			}
			
		}
	}
	public static void main(String[] args) throws Exception
	{
		ApplicationRun applicationRun=new ApplicationRun();
		applicationRun.run("com.king.contest2.MyClass");
	}


}

