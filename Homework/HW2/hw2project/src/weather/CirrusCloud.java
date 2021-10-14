package weather;

public class CirrusCloud extends Cloud {
	private float bottom;
	private float top;
	
	public CirrusCloud(float b, float t) {
		super(b, t);
	}
	
	public String rain() {
		return "I cannot make rain";
	}
}
