package recurse;

//DO NOT CODE RECURSIVELY, NOT EFFICIENT

public class FibGenerator {

	private int[] callCounter;
	
	public int nthFib(int n)
	{
		callCounter = new int[n+1];
		return this.computeFibRecurse(n);
	}
	
	private int computeFibRecurse(int n)
	{
		callCounter[n]++; 
		if(n == 1 || n == 2)
		{
			return n;
		}
		else
		{
			return this.computeFibRecurse(n-1) + this.computeFibRecurse(n-2);
		}
	}
	
	public void printCallCounter()
	{
		for(int i = 0; i < callCounter.length; i++)
		{
			System.out.println(callCounter[i] + " calls to fib(" + i + ")");
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("STARTING");
		//System.out.println(Integer.MAX_VALUE);
		FibGenerator test = new FibGenerator();
		/*for(int i = 0; i < 42; i++)
		{
			System.out.println(i+1 + ": " + test.nthFib(i+1));
		}*/
		System.out.println(test.nthFib(42));
		test.printCallCounter();
	}
}
