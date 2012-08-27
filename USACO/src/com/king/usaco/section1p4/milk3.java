package com.king.usaco.section1p4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milk3
{
	/*
	 * ID: verydar1 LANG: JAVA TASK: milk3
	 */

	// Important: BufferedReader and StringTokenizer are far more efficient than
	// many other schemes for reading input.
	// They can make a huge difference in the efficiency of your program! Use
	// them!
	// ����
	// ũ��Լ�������������ֱ���A,B,C����Ͱ��A,B,C�ֱ���������1��20�������� �����A��BͰ���ǿյģ���CͰ��װ��ţ�̵ġ�
	// ��ʱ��ũ���ţ�̴�һ��Ͱ���� ��һ��Ͱ�У�ֱ������Ͱװ����ԭͰ���ˡ�
	// ��Ȼÿһ�ι�ע������ȫ�ġ����ڽ�Լ�� ţ�̲����ж�ʧ��
	// дһ������ȥ����ũ���ҳ���AͰ�ǿյ�ʱ��CͰ��ţ����ʣ�������п����ԡ�

	// [�༭]��ʽ
	// PROGRAM NAME: milk3
	// INPUT FORMAT:
	// (file milk3.in)
	// ������һ�а�����������A,B��C��
	// OUTPUT FORMAT:
	// (file milk3.out)
	// ֻ��һ�У�������г���AͰ�ǿյ�ʱ��CͰţ����ʣ�������п����ԡ�
	public static void printBuckets(MilkBucket[] mb)
	{
		for (MilkBucket milkBucket : mb)
		{
			System.out.println("Volume:" + milkBucket.volume + " Current:"
					+ milkBucket.currentMilk);
		}
	}

	public final static int MAX = 20;
	public static int[][][] seen = new int[MAX + 1][MAX + 1][MAX + 1];
	public static int[] canget = new int[MAX + 1];

	public static MilkBucket[] pour(MilkBucket[] mbs, int from, int to)
	{
		System.out.println("Before:");
		print(mbs);
		System.out.println("From:" + from + " to:" + to);
		// judge the condition between the bucket and mbs[to]
		if (from == to)
			return mbs;
		if (mbs[from].currentMilk > (mbs[to].volume - mbs[to].currentMilk))
		{
			mbs[from].currentMilk -= mbs[to].volume - mbs[to].currentMilk;
			mbs[to].currentMilk = mbs[to].volume;
			System.out.println("After:");
			print(mbs);
			return mbs;
		}
		else
		{
			mbs[to].currentMilk += mbs[from].currentMilk;
			mbs[from].currentMilk = 0;
			System.out.println("After:");
			print(mbs);
			return mbs;
		}

	}

	public static void print(MilkBucket[] s)
	{
		for (MilkBucket mb : s)
			System.out.println(mb);
	}

	public static void search(MilkBucket[] s)
	{
		int i, j;
		if (seen[s[0].currentMilk][s[1].currentMilk][s[2].currentMilk] != 0)
			return;
		seen[s[0].currentMilk][s[1].currentMilk][s[2].currentMilk] = 1;
		if (s[0].currentMilk == 0) // bucket A empty
		{
			canget[s[2].currentMilk] = 1;
		}
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++)
				search(pour(s, i, j));
	}

	public static void main(String[] args) throws IOException
	{
		// α����
		long startTime = System.nanoTime(); // ��ȡ��ʼʱ��

		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk3.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int a = Integer.parseInt(st.nextToken()); // first integer
		int b = Integer.parseInt(st.nextToken()); // second integer
		int c = Integer.parseInt(st.nextToken()); // third integer
		// insert bucket A,B,C into an array
		MilkBucket abuc = new MilkBucket(a, 0);
		MilkBucket bbuc = new MilkBucket(b, 0);
		MilkBucket cbuc = new MilkBucket(c, c);
		MilkBucket[] mbs = new MilkBucket[3];
		mbs[0] = abuc;
		mbs[1] = bbuc;
		mbs[2] = cbuc;
		// start search
		search(mbs);

		f.close(); // close the input file

		for (int i = 0; i < canget.length; i++)
		{
			if (canget[i] == 1)
				System.out.print(i + " ");
		}
		System.out.println();
		out.close(); // close the output file
		long endTime = System.nanoTime(); // ��ȡ����ʱ��
		System.out.println("��������ʱ�䣺 " + (endTime - startTime) + " ns");
		System.exit(0); // don't omit this!
	}

}

class MilkBucket
{
	final int volume;
	public int currentMilk;

	MilkBucket(int volume, int currentMilk) {
		this.volume = volume;
		this.currentMilk = currentMilk;
	}

	@Override
	public String toString()
	{
		return "MilkBucket [volume=" + volume + ", currentMilk=" + currentMilk
				+ "]";
	}

}
