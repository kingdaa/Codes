package com.king.day0718;

public class ShowEnum
{
	public static void main(String[] args)
	{
		enumCompareTo(OpConstant.valueOf(args[0]));
	}
	public static void enumCompareTo(OpConstant constant){
		System.out.println(constant);
		for(OpConstant elem : OpConstant.values())
		{
			System.out.println(constant.compareTo(elem));
		}
		
	}

}
