
public class LinkedStackOfStrings
{
	private Node first = null;
	private class Node
	{
		String item;
		Node next;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public String pop()
	{
		if(!isEmpty())
		{
			String oldfirst=first.item;
			first=first.next;
			return oldfirst;
		}
		else return null;
	}
	public void push(String str)
	{
		Node oldfirst=first;
		first=new Node();
		first.item=str;
		first.next=oldfirst;
	}
}
