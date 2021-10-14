package cast;

public class Primitives {

	public static void dumpMaxValues() {
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		Primitives p = new Primitives();
		p.dumpMaxValues();
	}
}
