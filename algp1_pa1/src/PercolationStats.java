
public class PercolationStats
{
	private double[] percolationFraction; // the array recording number of opened sites
									// while percolates in each experiment
	private int rows;

	public PercolationStats(int N, int T) throws IllegalArgumentException // perform
																			// T
																			// independent
																			// computational
																			// experiments
																			// on
																			// an
																			// N-by-N
																			// grid
	{
		if(N<=0||T<=0) throw new IllegalArgumentException();
		rows = N;
		percolationFraction=new double[T];
		for (int i = 0; i < T; i++)
		{
			Percolation percolation = new Percolation(N);
			int count = 0;
			while (percolation.percolates() == false)
			{
				int randxtoOpen = StdRandom.uniform(1, N+1);
				int randytoOpen = StdRandom.uniform(1, N+1);
				if (!percolation.isOpen(randxtoOpen, randytoOpen))
				{
					percolation.open(randxtoOpen, randytoOpen);
					count++;
				}

			}
			percolationFraction[i] = (double)count/(double)(rows*rows);
		}
	}

	public double mean() // sample mean of percolation threshold
	{
		return StdStats.mean(percolationFraction);

	}

	public double stddev() // sample standard deviation of percolation threshold
	{
		return StdStats.stddev(percolationFraction);
	}
	public static void main(String[] args) // test client, described below
	{
//		double random = StdRandom.random();
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		int rand = StdRandom.uniform(a, b);
//		System.out.println(rand);
//		System.out.println(Integer.parseInt(args[0])+" "+Integer.parseInt(args[1]));
//		System.out.println(Math.sqrt(Float.parseFloat(args[1])));
//		PercolationStats percolationStats=new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//		double mean=percolationStats.mean();
//		double stddev=percolationStats.stddev();
//		double rootT=Math.sqrt(Float.parseFloat(args[1]));
//		double leftinterval=mean-(1.96*stddev/rootT);
//		double rightinterval=mean+(1.96*stddev/rootT);
//		StdOut.println("mean                    ="+mean);
//		StdOut.println("stddev                  ="+stddev);
//		StdOut.println("95% confidence interval ="+leftinterval+", "+rightinterval);
	}
}
