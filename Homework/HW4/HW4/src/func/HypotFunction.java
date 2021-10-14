package func;

public class HypotFunction implements DoubleFunctionOfTwoInts
{
	//returns hypotenuse with triangle whose lengths are x and y
	public double 	fOfXY(int x, int y) 
	{
		return Math.hypot(x, y);
	}
	
	//returns name of function
	public String 	getName() 
	{
		return "Hypotenuse";
	}
}
