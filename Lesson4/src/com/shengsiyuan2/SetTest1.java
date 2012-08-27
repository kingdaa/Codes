package com.shengsiyuan2;

import java.util.HashSet;

public class SetTest1 {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add("a");
		Deming deming=new Deming("Cong",24);
		System.out.println(Integer.toHexString(deming.hashCode()).toUpperCase());
		
		

	}

}

class Deming
{
	String demingname;
	int demingage;
	Deming(String dn,int da)
	{
		demingname=dn;
		demingage=da;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + demingage;
		result = prime * result
				+ ((demingname == null) ? 0 : demingname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deming other = (Deming) obj;
		if (demingage != other.demingage)
			return false;
		if (demingname == null) {
			if (other.demingname != null)
				return false;
		} else if (!demingname.equals(other.demingname))
			return false;
		return true;
	}
	
}
