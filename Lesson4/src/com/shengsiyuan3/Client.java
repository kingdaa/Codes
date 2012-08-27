package com.shengsiyuan3;

public class Client {
	public static void main(String[] args) {
		AddStrategy addStrategy=new AddStrategy();
		
		Environment environment=new Environment(addStrategy);
		
		System.out.println(environment.calculate(3, 4));
		
		SubstractStrategy substractStrategy=new SubstractStrategy();
		
		environment.setStrategy(substractStrategy);
		
		System.out.println(environment.calculate(3, 4));
		
		
		
		
	}

}
