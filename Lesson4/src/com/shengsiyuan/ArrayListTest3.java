package com.shengsiyuan;
import java.util.ArrayList;

public class ArrayListTest3 {
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add(3);
		int aa=(int) list.get(0);
		System.out.println(aa);
		Integer ab=new Integer(10);
		System.out.println(ab);
		Object aaobj=(Object)aa;
		System.out.println((Object)aaobj.getClass().toString());
		String abstr=ab.getClass().toString();
		System.out.println(abstr);
		
		ArrayList<Integer> listint=new ArrayList<Integer>();
	}

}
