import java.util.Date;

public class TestTiming
{
	private static double doWork(int count, int seed)
	{
//	    long start = System.currentTimeMillis();
		Stopwatch watch = new Stopwatch();
	    Timing.trial(count, seed);
	    return watch.elapsedTime()*1000;
//	    return System.currentTimeMillis()-start;
	}
	public static void main(String[] args)
	{
		// long startTime = new Date().getTime();
		// int N=16384;
		int seed = 305297;
		int start = 8192;
	    for(int n = start; n <= start << 5; n <<= 1)
	    {
	        double totaltime = 0;
	        for(int i = 0; i < 20; i++)
	        {
	            totaltime += doWork(n, seed);
	        }
	        System.out.println(String.format("%d: %f", n, totaltime/20));
	    }
		// Stopwatch stopwatch=new Stopwatch();
		// Timing.trial(N, seed);
		// long endTime = new Date().getTime();
		// System.out.println("本程序运行 " + (endTime - startTime)
		// + " 毫秒完成。" );
		// double totalTime=stopwatch.elapsedTime();
		// System.out.println(totalTime);
//		for (int i = 1; i < 10000000; i = 2 * i)
//		{
//			Timing.trial(i, seed);
//			StdOut.println(i + " " + watch.elapsedTime());
//		}
	}
}
