package com.shengsiyuan;
import java.util.ArrayList;

public class ArrayListTest1 {
	public static void main(String[] args)
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("hello");
		al.add("hello");
		al.add("deming!");
		al.remove("hello");
		for (int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}
		Object obj=al.size();
		String name=obj.getClass().toString();
		System.out.println(name);
		ArrayList list=new ArrayList();
		list.add("deming");
		list.add(new Integer(2));
		String str=(String)list.get(0);
		Integer in=(Integer)list.get(1);
		System.out.println(str);
		System.out.println(in.intValue());
		
		int test=0xffff^0x1000;
		
		System.out.println("test:"+Integer.toHexString(test).toUpperCase());
		
	}
	

}
