package func;

public class ComplexNormFunction implements DoubleFunctionOfTwoInts
{
	//returns norm of complex number
	// The "norm" of complex number a+bi is the square root of (a^2 + b^2).
	public double 	fOfXY(int x, int y) 
	{
		return Math.sqrt((x*x) + (y*y));
	}
	
	//returns name of function
	public String 	getName()
	{
		return "Complex Norm";
	}
}
