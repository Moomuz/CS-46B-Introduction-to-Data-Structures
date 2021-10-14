package space;

import java.util.ArrayList;


public class Mission implements Comparable<Mission>
{
	private String			destination;
	private float			cost;
	
	
	public Mission(String destination, Float cost)
	{
		this.destination = destination;
		this.cost = cost;
	}
	
	
	public String getDestination()
	{
		return destination;
	}
	
	
	public float getCost()
	{
		return cost;
	}


	// Compare by cost, then by destination.
	public int compareTo(Mission that) 
	{ 		
		int costCmp = (int)Math.signum(this.cost - that.cost);
		int destinationCmp = this.destination.compareTo(that.destination);
		if(costCmp != 0)
		{
			return costCmp;
		}
		else
		{
			return destinationCmp;
		}
	}
	
	
	// Let compareTo() do the work. This method should just be 1 line.
	public boolean equals(Object x)
	{
		Mission that = (Mission)x;
		return this.compareTo(that) != 0;

	}
	
	
	// As you saw in lecture, create an ArrayList<Object>. Add destination and
	// cost to the list. Return the list's hash code.
	public int hashCode()
	{
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(cost);
		list.add(destination);
		return list.hashCode();
	}
	
	
	public String toString()
	{
		return "Mission to " + destination + " will cost " + cost;
	}
	
	public static void main(String[] args)
	{
		Mission a = new Mission("Neverland", 3000000.5f);
		Mission b = new Mission("Narnia", 2500f);
		System.out.println(a.equals(b));
		System.out.println(a.compareTo(b));
		System.out.println(a.hashCode());
	}
}
