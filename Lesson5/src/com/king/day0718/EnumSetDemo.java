package com.king.day0718;

import java.util.EnumSet;
import java.util.Iterator;


enum FontConstant
{
	Plain,Bold,Italic,Deming
}

public class EnumSetDemo
{
	public static void main(String[] args)
	{
		EnumSet<FontConstant> enumSet= EnumSet.of(FontConstant.Bold,FontConstant.Deming);
		EnumSet<FontConstant> enumSetb= EnumSet.complementOf(enumSet);
		showEnumSet(enumSet);
		System.out.println("-----------------");
		showEnumSet(enumSetb);
	}
	public static void showEnumSet(EnumSet<FontConstant> enumSet)
	{
		for(Iterator<FontConstant> iter=enumSet.iterator();iter.hasNext();) 
		{
			System.out.println(iter.next());
				
		}
		
	}

}
