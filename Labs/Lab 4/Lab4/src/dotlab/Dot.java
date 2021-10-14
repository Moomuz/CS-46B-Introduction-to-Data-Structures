package dotlab;


public class Dot 
{
	private String color;
	private int x;
	private int y;
	private int radius;
	
	public Dot(String a, int x, int y, int radius)
	{
		boolean isEqual = false;
		for(String b: LEGAL_COLOR_NAMES)
		{
			if(a.equals(b))
			{
				this.color = a;
				isEqual = true;
			}
		}
		if(isEqual == false)
		{
			System.out.print(a + " is not a valid color.");
		}
		
		/* ^ what is supposed to replace if statement above
		 * else
		 * {
		 * throw new IllegaArgumentException("Bad Color Name: + " " + this.color);
		 * }
		 */
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public String getColorName() 
	{
		return this.color;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getRadius()
	{
		return this.radius;
	}
	
	private static String[] 	LEGAL_COLOR_NAMES =
	{
		"RED", "YELLOW", "BLUE", "CYAN", "GREEN", "MAGENTA", "ORANGE", "BLACK"
	};
	
	public String toString()
	{
		return "color: " + this.color + 
			   ", x: " + this.x +
			   ", y: " + this.y +
			   ", radius: " + this.radius;
	}

	public static void main(String[] args)
	{
		Dot a = new Dot("RED", 20, 20, 20);
		//Dot b = new Dot("DUCKS", 50, 50, 100);
		System.out.println(a.toString());
	}
}
