package func;

public class ComplexSquaredNormFunction implements DoubleFunctionOfTwoInts
{
	//returns norm of product of two complex numbers
	//The product of two complex numbers is the following formula: (a+bi) times (c+di) = ac-bd + (ad+bc)i
	// The "norm" of complex number a+bi is the square root of (a^2 + b^2).
	public double 	fOfXY(int x, int y) 
	{
		double mReal = (x*x) - (y*y);
		double mImaginary = 2 * (x*y);
		return Math.sqrt((mReal * mReal) + (mImaginary * mImaginary));
	}
	
	//returns name of function
	public String 	getName()
	{
		return "Complex Squared Norm";
	}
}
