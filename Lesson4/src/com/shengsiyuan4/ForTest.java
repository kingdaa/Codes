package com.shengsiyuan4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ForTest
{
	public static void main(String[] args)
	{
		//old style for loop
		int[] arr = { 1, 2, 3, 4, 5 };
//		for (int i = 0; i < arr.length; i++)
//		{
//			System.out.println(arr[i]);
//		}
		//new enhanced style in jdk5
		for(int element : arr)
		{
			System.out.println(element);
		}
		Collection <String> col=new ArrayList<String>();
		col.add("one");
		col.add("two");
		col.add("three");
		for(String elem : col)
			System.out.println(elem);
		for(Iterator<String> iter=col.iterator();iter.hasNext();)
			System.out.println(iter.next());
		
	}

}
