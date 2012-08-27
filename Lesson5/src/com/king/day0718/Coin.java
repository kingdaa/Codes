package com.king.day0718;

public enum Coin {
	//Inherited from java.lang.Enum
	//Every member in Enum type is [public static final] in default
	//Every member is an instance of this enum type
	penny, nickel("deming"), cong("clever"), quarter("hello world");
	//penny uses Coin() constructor
	private String value;
	public String getValue()
	{
		return value;
	}
	Coin(String value)
	{
		this.value=value;
	}
	Coin()
	{
		this.value="congdeming";
	}

}
