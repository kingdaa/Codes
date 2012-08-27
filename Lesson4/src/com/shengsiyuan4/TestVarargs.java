package com.shengsiyuan4;

public class TestVarargs
{
	private static int sum(int... nums) //可变参数
	{
		int sum = 0;
		for (int num : nums)
		{
			sum += num;
		}
		return sum;

	}

	public static void main(String[] args)
	{
		int result=sum(1,2);
		System.out.println(result);
		result=sum(1,2,3,4,5);
		System.out.println(result);
		int[] array=new int[]{1,3,4,5,6,7,8};
		result=sum(array);
		System.out.println(result);

	}

}
