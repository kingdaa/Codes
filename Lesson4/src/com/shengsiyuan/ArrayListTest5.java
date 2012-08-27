package com.shengsiyuan;
import java.util.ArrayList;
/**
 * 
 * @author King
 * @category <h1>Deming</h1>
 *
 */

public class ArrayListTest5 {
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add(new Point(2,3));
		list.add(new Point(3,3));
		list.add(new Point(6,3));
		list.add(new Point(2,13));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list);
	}

}
class Point
{
	int x;
	int y;
	/*
	 * @param x coordinate of x
	 * @param y coordinate of y
	 */
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	/**
	 * @return return coordinate of axis of x and y
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x="+this.x+", y=" +this.y+";";
	}
}
