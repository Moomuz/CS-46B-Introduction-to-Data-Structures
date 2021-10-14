package recurse;

public class DoubleFactorial {
	
	public double nthFactorial(int n)
	{
		return this.computeFactorialRecurse(n);
	}
	
	private double computeFactorialRecurse(int n)
	{
		assert n >= 0: "Illegal n: " + n;
		if(n == 0)
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
		System.out.println("Max double value: " + Double.MAX_VALUE);
		/*for(int i = 0; i < 32; i++)
		{
			System.out.println(i + ": " + test.nthFactorial(i));
		}*/
		System.out.println(test.nthFactorial(-1));
	}
}
