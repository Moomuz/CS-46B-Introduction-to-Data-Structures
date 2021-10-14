package airlines;

import java.util.HashSet;

public class FlightNet extends HashSet<Airport>
{
	// Returns true if the FlightNet doesn't contain an airport 
	// with the specified name.
	public boolean nameIsAvailable(String name)
	{
		for(Airport a: this)
		{
			if(a.getName().equals(name))
				return false;
		}
		return true;
	}
	
	// Connects a1 and a2 in both directions.
	public void connect(Airport a1, Airport a2)
	{
		a1.connectTo(a2);
		a2.connectTo(a1);
	}
	
	// Disconnects a1 and a2 in both directions.
	public void disconnect(Airport a1, Airport a2)
	{
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}
	
	// Removes removeMe from the FlightNet, and disconnects it 
	// from any airports that are still in the FlightNet. 
	public void removeAndDisconnect(Airport removeMe)
	{
		for(Airport a: this)
		{
			if(a.equals(removeMe))
			{
				disconnect(a, removeMe);
			}
		}
		this.remove(removeMe);
	}
	
	// Checks all airports in the FlightNet. Returns the first airport 
	// whose (x,y) location is within maximumDistance of the (x,y) args of the method. 
	// Returns null if not airport is within MaximumDistance.
	public Airport getAirportNearXY(int x , int y, int maximumDistance)
	{
		for(Airport a: this)
		{
			int deltaX = Math.abs(a.getX() - x);
			int deltaY = Math.abs(a.getY() - y);
			Double distance = Math.hypot(deltaX, deltaY);
			if(distance < maximumDistance)
			{
				return a;
			}
		}
		return null;
	}
	

}
