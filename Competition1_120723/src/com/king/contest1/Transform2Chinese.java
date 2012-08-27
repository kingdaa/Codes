package com.king.contest1;

import java.util.ArrayList;
import java.util.Collections;

public class Transform2Chinese
{
	public static final String[] ChnNum = { "零", "一", "二", "三", "四", "五", "六",
			"七", "八", "九" };
	public static final String[] ChnDemension = { "十", "百", "千" };
	public static final String TenThousand = "万";

	public static String processFourDigits(int fourdigits)
	{
		if (fourdigits == 0)
			return "";
		ArrayList<String> output = new ArrayList<String>();
		char[] numCharArr = Integer.toString(fourdigits).toCharArray();
		int lastNumIndex = numCharArr.length - 1;
		// firstly, process the smallest digit
		if (Integer.parseInt(Character.toString(numCharArr[lastNumIndex])) != 0)
		{
			output.add(ChnNum[Integer.parseInt(Character
					.toString(numCharArr[lastNumIndex]))]);
		}
		// then iteratively process remained digits
		int DemensionIndex = 0;
		for (int i = lastNumIndex - 1; i >= 0; i--)
		{
			if (Integer.parseInt(Character.toString(numCharArr[i])) == 0)
			{
				while(Integer.parseInt(Character.toString(numCharArr[i-1])) == 0)
				{
					i--;
					DemensionIndex++;
				}
				if (!output.isEmpty())
					output.add(ChnNum[0]);
				DemensionIndex++;
				continue;
			}
			else
			{
				output.add(ChnDemension[DemensionIndex]);
				output.add(ChnNum[Integer.parseInt(Character
						.toString(numCharArr[i]))]);
			}
			DemensionIndex++;
		}
		Collections.reverse(output);
		String outputStr = "";
		for (String str : output)
		{
			outputStr += str;
		}
		return outputStr;
	}

	public static String transform(String input)
	{
		if (isNumeric(input))
		{
			// Transform to Integer and trim the zeros at head
			int numValue = Integer.valueOf(input);
			// Judge if the input number is too large
			if (numValue >= 100000000)
			{
				String tooLargeEx = "Input is too large!";
				return tooLargeEx;
			}
			// Transform the input number to a char array, to read each bit
			int firstFour = 0, lastFour = 0;
			if (numValue >= 10000)
			{
				firstFour = numValue / 10000;
				lastFour = numValue - firstFour * 10000;
				System.out.println("firstFour="+firstFour+" lastFour="+lastFour);

			}
			else
			{
				lastFour = numValue;
			}
			String result="";
			String firstStr=processFourDigits(firstFour);
			String lastStr=processFourDigits(lastFour);
			System.out.println(firstStr);
			System.out.println(lastStr);
			if (firstFour>0&&lastFour<1000&&lastFour>0)
			{
				result=firstStr+TenThousand+ChnNum[0]+lastStr;
			}
			else
			{
				result=firstStr+TenThousand+lastStr;
			}
			return result;

			// char[] numCharArr = Integer.toString(numValue).toCharArray();
			// int lastNumIndex = numCharArr.length - 1;
			// // firstly, process the smallest digit
			//
			// if (numCharArr[lastNumIndex] != 0)
			// {
			// output.add(ChnNum[Integer.parseInt(Character
			// .toString(numCharArr[lastNumIndex]))]);
			// }
			// // then iteratively process remained digits
			// int DemensionIndex = 0;
			// int DigitCount = 1;
			// for (int i = lastNumIndex - 1; i >= 0; i--)
			// {
			// if (++DigitCount == 5)
			// {
			// output.add(TenThousand);
			// DemensionIndex = 0;
			// if (numCharArr[lastNumIndex] != 0)
			// {
			// output.add(ChnNum[Integer.parseInt(Character
			// .toString(numCharArr[lastNumIndex]))]);
			// }
			// continue;
			// }
			// if (numCharArr[i] == 0)
			// {
			// output.add(ChnNum[0]);
			// }
			// else
			// {
			// output.add(ChnDemension[DemensionIndex]);
			// output.add(ChnNum[Integer.parseInt(Character
			// .toString(numCharArr[i]))]);
			// }
			// DemensionIndex++;
			// }

		}
		else
		{
			String notNumEx = "Sorry, your input is not a number!";
			return notNumEx;
		}

	}

	public static boolean isNumeric(String str)
	{
		for (char ch : str.toCharArray())
		{
			if (!Character.isDigit(ch))
			{
				return false;
			}

		}
		return true;

	}

	public static void main(String[] args)
	{
		String str = "10100000";
//		int test=2001;
//		System.out.println(processFourDigits(test));
//		System.out.println(processFourDigits(test2));
//		System.out.println(processFourDigits(test3));
		System.out.println(transform(str));

	}

}
