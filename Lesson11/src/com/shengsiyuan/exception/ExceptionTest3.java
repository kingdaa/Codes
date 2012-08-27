package com.shengsiyuan.exception;

public class ExceptionTest3
{
	public static void main(String[] args) throws Exception //Declaration, no need to [new]
	{
		String str = null;

		try //code block which may cause exception
		{
			System.out.println(str.length());
		}
		catch (Exception e) //if an exception is caught, execute code in the block
		{
			e.printStackTrace();
			System.out.println("An exception!");
		}
		finally //will always be executed despite if there is an exception
		{
			System.out.println("Finally.");
		}
	}
}
