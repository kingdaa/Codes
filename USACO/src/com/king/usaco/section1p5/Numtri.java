/*
ID: verydar1
PROG: numtri
LANG: JAVA
*/
package com.king.usaco.section1p5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//DP
public class Numtri
{
	public static final int NULLNUM = -1;

	public static int dp(int[][] numTriangle, int rowNum)
	{
		int[][] results = new int[rowNum][rowNum];
		// the first row
		for (int i = 0; i < rowNum; i++)
			results[0][i] = numTriangle[0][i];
		// the remained rows
		int count = 2;
		for (int j = 1; j < rowNum; j++)
		{
			for (int k = 0; k < count; k++)
			{
				int leftP = results[j - 1][k] + numTriangle[j][k];
				int rightP = 0;
				if (k > 0)
					rightP = results[j - 1][k - 1] + numTriangle[j][k];
				results[j][k] = leftP >= rightP ? leftP : rightP;
			}
			count++;
		}
		int max=0;
		max=results[rowNum-1][0];
		for (int i = 0; i < rowNum; i++)
		{
			if(results[rowNum-1][i]>max)
			{
				max=results[rowNum-1][i];
			}
			
		}

		return max;

	}

	public static void main(String[] args) throws Exception
	{
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"numtri.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		int rowNum = Integer.parseInt(st.nextToken());
		// System.out.println(rowNum);
		int[][] nums = new int[rowNum][rowNum];
		for (int i = 0; i < rowNum; i++)
			for (int j = 0; j < rowNum; j++)
				nums[i][j] = NULLNUM;
		int count = 1;
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < rowNum; i++)
		{
			for (int j = 0; j < count; j++)
			{
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
			if (count < rowNum)
				st = new StringTokenizer(f.readLine());
			else
				break;
			count++;
		}
		f.close();
		int result=dp(nums,rowNum);
		out.println(result);
		out.close();
	
	}

}
