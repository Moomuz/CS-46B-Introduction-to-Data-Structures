package func;

public class MyCreativeFunction implements DoubleFunctionOfTwoInts
{
	public double 	fOfXY(int x, int y)
	{
		int n = 30;			//height and width of one "pixel"
		double body = 40.0; //sets colors of duck parts
		double beak = 20.0; 			
		double eye = 0.0;
		if(x > -6*n && x < -2*n && y > 0 && y < n) 				//first line above x-axis
			return body;
		else if(x > 0 && x < 3*n && y > 0 && y < n)
			return body;
		else if(x > -1*n && x < 2*n && y > n && y < 2*n) 		//second line above
			return body;
		else if(x > 2*n && x < 5*n && y > n && y < 2*n)
			return beak;
		else if(x > -2*n && x < 3*n && y > 2*n && y < 3*n) 		//third line above
			return body;
		else if(x > 3*n && x < 6*n && y > 2*n && y < 3*n)
			return beak;
		else if(x > -2*n && x < n && y > 3*n && y < 4*n) 		//fourth line above
			return body;
		else if(x > n && x < 2*n && y > 3*n && y < 4*n)
			return eye;
		else if(x > 2*n && x < 3*n && y > 3*n && y < 4*n)
			return body;
		else if(x > 3*n && x < 4*n && y > 3*n && y < 4*n)
			return beak;
		else if(x > -2*n && x < 4*n && y > 4*n && y < 5*n) 		//fifth line above
			return body;
		else if(x > -1*n && x < 3*n && y > 5*n && y < 6*n) 		//sixth line above
			return body;
		else if(x > -6*n && x < 4*n && y > -1*n && y < 0) 		//first line below x-axis
			return body;
		else if(x > -6*n && x < 5*n && y > -2*n && y < -1*n) 	//second line below 
			return body;
		else if(x > -6*n && x < 5*n && y > -3*n && y < -2*n)	//third line below 
			return body;
		else if(x > -6*n && x < 5*n && y > -4*n && y < -3*n) 	//fourth line below 
			return body;
		else if(x > -5*n && x < 4*n && y > -5*n && y < -4*n)	//fifth line below 
			return body;
		else if(x > -4*n && x < 3*n && y > -6*n && y < -5*n)	//fifth line below 
			return body;
		else
			return 150.0; //background color

	}
	public String 	getName() 
	{
		return "Quack";
	}
}
