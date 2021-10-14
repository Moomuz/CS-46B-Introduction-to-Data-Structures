package weather;

import java.util.ArrayList;

public class Sky {
	private ArrayList<Cloud> clouds;
	
	public Sky() {
		clouds = new ArrayList<Cloud>(100);
	}
	
	public boolean add(Cloud c) { 
		clouds.add(c);
		return true;
	}
	
	public float getMeanHeight() {
		float sum = 0;
		for(Cloud c: clouds) 
			sum += c.getHeight();
		return sum/clouds.size();
	}
	
	public static void main(String[] args) {
		StratusCloud strat = new StratusCloud(100,1000); //initializes each cloud
		if(!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");
		CumulusCloud cumu = new CumulusCloud(200,2000);
		if(!cumu.rain().startsWith("It is raining"))
			System.out.println("Bad CumulusCloud::rain");
		CirrusCloud cirr = new CirrusCloud(300,3000);
		if(!cirr.rain().startsWith("I cannot make"))
			System.out.print("Badd CirrusCloud::rain");
		
		Sky sky = new Sky(); //adds each cloud to Sky
		sky.add(strat);
		sky.add(cumu);
		sky.add(cirr);
		
		float mean = sky.getMeanHeight(); //returns message according to avg cloud height
		if(mean < 1799 || mean > 1801) //if not 1800
				System.out.print("Bad mean height: expected 1800, saw " + mean);
		System.out.println("Everything (else) is ok"); 
	}
}
