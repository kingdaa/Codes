package com.king.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Target: Control the class Customer and reach the private
// members.
//在未知目标对象类名称的情况下复制一个对象实例

public class ReflectTester
{
	//Copy Customer object
	public Object copy(Object object) throws Exception
	{ 
		Class<?> classType =object.getClass();
		Constructor<?> constructor= classType.getConstructor(new Class[]{String.class,int.class});
//		Object obj=constructor.newInstance(new Object[]{"hello",3});
//		//以上两行代码等价于下面一行
//		Object obj2=classType.newInstance();
//		System.out.println(obj);
//		System.out.println(obj2);
//		return obj;
		Object objectCopy=classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
		Field[] fields = classType.getDeclaredFields();
		for(Field field : fields)
		{
			String name=field.getName();
			//get the first letter of the attr and transform it to uppercase
			String firstLetter=name.substring(0,1).toUpperCase();//包含左边，不包含右边
			String getMethodName="get"+firstLetter+name.substring(1);
			String setMethodName="set"+firstLetter+name.substring(1);
//			System.out.println(getMethodName+","+setMethodName);
			Method getMethod=classType.getMethod(getMethodName, new Class[]{});
			Method setMethod=classType.getMethod(setMethodName, new Class[]{field.getType()});
			Object value = getMethod.invoke(object, new Object[]{});
			setMethod.invoke(objectCopy, new Object[]{value});
			
			
		}
		return objectCopy;
		
	}
	public static void main(String[] args) throws Exception
	{
		ReflectTester reflectTester= new ReflectTester();
//		Object demingcopy=reflectTester.copy(new Customer("Deming",25));
		Customer customer=new Customer("Deming",23);
		customer.setId(1L);
		Customer replicate=(Customer)reflectTester.copy(customer);
		System.out.println(customer);
		System.out.println(replicate);
		
	}

}
class Customer
{
	private Long id;
	private String name;
	private int age;
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		String result="Age:"+age+"  Name:"+name;
		return result;
	}
	public Customer()
	{
		
	}
	public Customer(String name, int age)
	{
		this.name=name;
		this.age=age;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
}
