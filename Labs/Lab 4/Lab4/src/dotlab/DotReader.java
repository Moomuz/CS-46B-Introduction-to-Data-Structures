package dotlab;

import java.io.*;


public class DotReader 
{
	private BufferedReader			br;
	
	public DotReader(BufferedReader br)
	{
		this.br = br;
	}
	
	public Dot readDot() throws IOException, DotException
	{
		String temp = br.readLine();			//reads one line
		if(temp == null)
		{
			return null;						//if string is null, returns null object
		}
		String[] a = temp.split(",");			//splits string into array
		if(a.length != 4)
		{
			throw new DotException("Array is not of length 4.");
		}
		//a[0] = color
		int x = Integer.parseInt(a[1]);			//parses string numbers into ints
		int y = Integer.parseInt(a[2]);
		int radius = Integer.parseInt(a[3]);
		Dot b = new Dot(a[0], x, y, radius);	//creates new dot object using array
		return b;
	}
	
}
