import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;

	private class Node
	{
		Item item;
		Node next;
		Node prev;
	}

	public Deque() // construct an empty deque
	{
		first = null;
		last = first;
	}

	public boolean isEmpty() // is the deque empty?
	{
		return first == null;
	}

	public int size() // return the number of items on the deque
	{
		int size = 0;
		return size;
	}

	public void addFirst(Item item) throws NullPointerException // insert the
																// item at the
																// front
	{
		if (item == null)
			throw new NullPointerException();
		Node newfirst = new Node();
		newfirst.item = item;
		newfirst.next = first;
		newfirst.prev = null;
		if (isEmpty())
		{
			first = newfirst;
			last = first;
		}
		else
		{
			first = newfirst;
		}

	}

	public void addLast(Item item) // insert the item at the end
	{
		if (item == null)
			throw new NullPointerException();
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
		{
			oldlast.next = last;
			secondlast = oldlast;
		}
	}

	public Item removeFirst() // delete and return the item at the front
	{
		Item item = first.item;
		if (first == secondlast)
		{
			first = first.next;
			secondlast = null;
		}
		else
		{
			first = first.next;
		}
		return item;
	}

	public Item removeLast() // delete and return the item at the end
	{
		if (secondlast == null)
		{
			Item item = last.item;
			last = null;
			first = last;
			return item;
		}
		else
		{
			Item item = last.item;
			last = secondlast;
			if()
			return item;
		}
	}

	public Iterator<Item> iterator() // return an iterator over items in order
										// from front to end
	{
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;

		@Override
		public boolean hasNext()
		{
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() throws NoSuchElementException
		{
			// TODO Auto-generated method stub
			if (current == null)
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() throws UnsupportedOperationException
		{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();

		}

	}

	public static void main(String[] args)
	{
		Deque<String> deque = new Deque<String>();
		StdOut.println(deque.isEmpty());
		deque.addFirst("deming");
		StdOut.println(deque.isEmpty());
	}
}