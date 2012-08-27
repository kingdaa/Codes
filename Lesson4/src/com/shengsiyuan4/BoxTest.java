package com.shengsiyuan4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BoxTest
{
	public static void main(String[] args)
	{
		int a=3;
		Collection<Integer> col=new ArrayList<Integer>();
		//Automatically change int to Integer and insert into collection
		col.add(a);
		col.add(3);
		System.out.println(col);
	}

}
