package com.shengsiyuan4;

import java.util.Vector;
//Vector是同步的。

public class VectorTest {
	public static void main(String[] args) {
		Vector vector=new Vector();
		vector.add("Hello! deming");
		vector.add("! deming");
		vector.add("Hello! ");
		vector.add("Heleming");
		System.out.println(vector);
		
		
	}

}
