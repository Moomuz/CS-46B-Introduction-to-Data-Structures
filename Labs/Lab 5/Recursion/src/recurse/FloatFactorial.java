package recurse;

public class FloatFactorial {
	
	public float nthFactorial(int n)
	{
		return this.computeFactorialRecurse(n);
	}
	
	private float computeFactorialRecurse(int n)
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
		System.out.println("Max long value: " + Float.MAX_VALUE);
		for(int i = 0; i < 32; i++)
		{
			System.out.println(i + ": " + test.nthFactorial(i));
		}
		
	}
}
