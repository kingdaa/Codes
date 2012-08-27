public class Percolation
{
	private WeightedQuickUnionUF unionFind;
	private WeightedQuickUnionUF UF2;
	private int row;
	private int virtualTop, virtualBottom;
	private boolean[][] ifSiteOpen;

	private int xyTo1D(int x, int y)
	{
		int position = (x - 1) * row + (y - 1); // reflect the 2-dimensional
												// coordinate to array index
		return position;
	}

	public Percolation(int N) // create N-by-N grid, with all sites blocked
	{
		row = N;
		unionFind = new WeightedQuickUnionUF(N * N + 2);
		UF2 = new WeightedQuickUnionUF(N * N);
		for (int i = 0; i < row; i++)
		{
			unionFind.union(N * N, i);
		}
		for (int j = row * (row - 1); j < row * row; j++)
		{
			unionFind.union(N * N + 1, j);
		}
		virtualTop = N * N;
		virtualBottom = N * N + 1;
		ifSiteOpen = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				ifSiteOpen[i][j] = false;
	}

	public void open(int i, int j) // open site (row i, column j) if it is not
									// already
	{
		ifSiteOpen[i - 1][j - 1] = true;
		int position = xyTo1D(i, j); // reflect the 2-dimensional coordinate to
										// array index
		int up = position;
		int down = position;
		int left = position;
		int right = position;
		if (position > row - 1)
		{
			up -= row;
			int xup = i - 1;
			int yup = j;
			if (isOpen(xup, yup) && !UF2.connected(position, up))
			{
				unionFind.union(position, up);
				UF2.union(position, up);
			}

		}
		if (position < row * (row - 1))
		{
			down += row;
			int xdown = i + 1;
			int ydown = j;
			if (isOpen(xdown, ydown) && !UF2.connected(position, down))
			{
				unionFind.union(position, down);
				UF2.union(position, down);
			}

		}
		if (position % row != 0)
		{
			left--;
			int xleft = i;
			int yleft = j - 1;
			if (isOpen(xleft, yleft) && !UF2.connected(position, left))
			{
				unionFind.union(position, left);
				UF2.union(position, left);
			}

		}
		if ((position - row + 1) % row != 0)
		{
			right++;
			int xright = i;
			int yright = j + 1;
			if (isOpen(xright, yright) && !UF2.connected(position, right))
			{
				unionFind.union(position, right);
				UF2.union(position, right);
			}
		}

	}

	public boolean isOpen(int i, int j) // is site (row i, column j) open?
	{
		if (ifSiteOpen[i - 1][j - 1] == true)
			return true;
		return false;
	}

	public boolean isFull(int i, int j) // is site (row i, column j) full?
	{
		int position = xyTo1D(i, j);
		if (percolates() == false)
		{
			if (!isOpen(i, j))
				return false;
			else
			{
				if (unionFind.connected(virtualTop, position))
					return true;
				return false;
			}
		}
		else
		{
			if (!isOpen(i, j))
				return false;
			else
			{
				for (int index = 0; index < row; index++)
				{
					if (UF2.connected(index, position))
						return true;
				}
				return false;
			}
		}
	}

	public boolean percolates() // does the system percolate?
	{
		if (row == 1)
		{
			if (isOpen(1, 1))
				return true;
			else
				return false;
		}
		else
		{
			if (unionFind.connected(virtualTop, virtualBottom))
			{
				return true;
			}
			return false;
		}
	}

	// private int booltoInt(boolean bool)
	// {
	// if (bool == true)
	// return 1;
	// else
	// return 0;
	// }

	// public void printSites()
	// {
	// for (int i = 0; i < row; i++)
	// {
	// for (int j = 0; j < row; j++)
	// {
	// StdOut.print(booltoInt(ifSiteOpen[i][j]) + " ");
	// }
	// StdOut.println();
	// }
	// }

	public static void main(String[] args) throws Exception
	{
		// int N;
		// N = Integer.parseInt(args[0]);
		// System.out.println("N=" + N);
		// Percolation percolation = new Percolation(N);
		// int count = 0;
		// System.out.println(percolation.isFull(1, 1));
		// while (percolation.percolates() == false)
		// {
		// int randxtoOpen = StdRandom.uniform(1, N + 1);
		// int randytoOpen = StdRandom.uniform(1, N + 1);
		// if (!percolation.isOpen(randxtoOpen, randytoOpen))
		// {
		// percolation.open(randxtoOpen, randytoOpen);
		// count++;
		// }
		//
		// }
		// System.out.println("count= " + count);
		//
		// percolation.printSites();
		// System.out.println(percolation.isFull(1, 1));

	}

}