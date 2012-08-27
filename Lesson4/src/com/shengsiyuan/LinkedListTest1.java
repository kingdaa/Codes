package com.shengsiyuan;
import java.util.LinkedList;

public class LinkedListTest1 {
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		
		list.add("F");
		list.add("E");
		list.add("B");
		list.add("Z");
		list.add("O");
		list.addFirst("DEMING");
		list.remove("DEMING");
		System.out.println(list);
		
		
	}

}
