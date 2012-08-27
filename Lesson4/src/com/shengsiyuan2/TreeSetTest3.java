package com.shengsiyuan2;

import java.util.*;

public class TreeSetTest3 {
	public static void main(String[] args) {
		TreeSet ts=new TreeSet(new MyComparator());
//		TreeSet ts=new TreeSet();
		
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("P");
		ts.add(">");
		
		for(Iterator iter=ts.iterator();iter.hasNext();)
		{
			String value=(String)iter.next();
			System.out.println(value);
		}
		

	}

}
class MyComparator implements Comparator
{
	public int compare(Object arg0,Object arg1)
	{
		String s1=(String)arg0;
		String s2=(String)arg1;
		
		return s2.compareTo(s1);
		
		
	}
}
class PersonComparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
