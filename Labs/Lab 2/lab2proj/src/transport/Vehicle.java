package transport;

public class Vehicle {
	private int nWheels;
	private double xPosition;
	private double yPosition;
	
	public Vehicle() {
		System.out.println("Vehicle ctor");
	}
	
	public void setPosition(double xPosition, double yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public double xPosition() {
		return this.xPosition;
	}
	
	public double yPosition() {
		return this.yPosition;
	}
	
	public void changePositionBy(double xDelta, double yDelta) {
		this.xPosition += xDelta;
		this.yPosition += yDelta;
	}
	public static void main(String[] args) {
		int i = 10;
		System.out.print(i);
		i = i + 100;
		System.out.print(i);
		i = i + 1000;
		System.out.print(i);
	}
}
