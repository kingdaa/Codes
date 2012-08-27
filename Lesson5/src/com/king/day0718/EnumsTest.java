package com.king.day0718;

import java.util.Random;

public class EnumsTest
{
	public static void doOp(OpConstant opConstant)
	{
		switch (opConstant) {
		case TURN_LEFT:
			System.out.println("向左转");
			break;
		case TURN_RIGHT:
			System.out.println("向右转");
			break;
		case SHOOT:
			System.out.println("射击");
			break;
		default:
			break;
		}
	}
	public static void main(String[] args)
	{
		Random rand=new Random();
		int randnum=rand.nextInt(3);
		System.out.println(randnum);
		OpConstant opConstant=OpConstant.values()[randnum];
		doOp(opConstant);

		Coin coin=Coin.values()[randnum];
		System.out.println(coin.getValue());
			
	}

}
enum OpConstant
{
	TURN_LEFT, TURN_RIGHT, SHOOT
}

