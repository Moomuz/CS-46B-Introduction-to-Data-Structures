package recurse;

//CAN BE WRITTEN RECURSIVELY, BUT BETTER NOT TO

public class factorial {
	
	public long nthFactorial(int n)
	{
		return this.computeFactorialRecurse(n);
	}
	
	private long computeFactorialRecurse(int n)
	{
		if(n <= 1)
		{
			return 1;
		}
		else
		{
			return n * computeFactorialRecurse(n-1);
		}
	}
	
	public static void main(String[] args)
	{
		factorial test = new factorial();
		System.out.println("Max long value: " + Long.MAX_VALUE);
		for(int i = 0; i < 32; i++)
		{
			System.out.println(i + ": " + test.nthFactorial(i));
		}
		
	}
}
