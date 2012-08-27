public class StackofObject<Item>
{
	private Node first = null;

	private class Node
	{
		Item item;
		Node next;
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public Item pop()
	{
		if (!isEmpty())
		{
			Item oldfirst = first.item;
			first = first.next;
			return oldfirst;
		}
		else
			return null;
	}

	public void push(Item it)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = it;
		first.next = oldfirst;

	}
}
