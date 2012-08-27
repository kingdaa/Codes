//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class RandomizedQueue<Item> implements Iterable<Item>
//{
//	private Item[] a = (Item[]) new Object[1];
//	private int N = 0;
//
//	public RandomizedQueue() // construct an empty randomized queue
//	{
//		
//	}
//
//	public boolean isEmpty() // is the queue empty?
//	{
//		return N == 0;
//	}
//
//	public int size() // return the number of items on the queue
//	{
//		return N;
//	}
//
//	private void resize(int max)
//	{
//		Item[] temp = (Item[]) new Object[max];
//		for (int i = 0; i < N; i++)
//			temp[i] = a[i];
//		a = temp;
//
//	}
//
//	public void enqueue(Item item) // add the item
//	{
//		if(N==a.length) resize(2*a.length);
//		a[N++]=item;
//	}
//
//	public Item dequeue() // delete and return a random item
//	{
//
//	}
//
//	public Item sample() // return (but do not delete) a random item
//	{
//
//	}
//
//	public Iterator<Item> iterator() // return an independent iterator over
//										// items in random order
//	{
//		return new ListIterator();
//	}
//
//	private class ListIterator implements Iterator<Item>
//	{
//		private Node current = first;
//
//		@Override
//		public boolean hasNext()
//		{
//			// TODO Auto-generated method stub
//			return current != null;
//		}
//
//		@Override
//		public Item next() throws NoSuchElementException
//		{
//			// TODO Auto-generated method stub
//			if (current == null)
//				throw new NoSuchElementException();
//			Item item = current.item;
//			current = current.next;
//			return item;
//		}
//
//		@Override
//		public void remove() throws UnsupportedOperationException
//		{
//			// TODO Auto-generated method stub
//			throw new UnsupportedOperationException();
//
//		}
//
//	}
//}