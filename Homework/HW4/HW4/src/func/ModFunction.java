package func;

public class ModFunction implements DoubleFunctionOfTwoInts{
	
	//returns x modulo y
	public double 	fOfXY(int x, int y) {
		return (double)x % y;
	}
	public String 	getName() {
		return "Modulus";
	}

}
