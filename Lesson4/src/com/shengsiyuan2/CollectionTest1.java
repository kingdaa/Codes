package com.shengsiyuan2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class CollectionTest1 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.add(new Integer(-29));
		list.add(new Integer(23));
		list.add(new Integer(13));
		list.add(new Integer(2));
		list.add(new Integer(1));
		list.add(new Integer(12));
		
		Comparator r=Collections.reverseOrder();
		Collections.sort(list,r);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		System.out.println(Collections.max(list));
		
		
	}

}

