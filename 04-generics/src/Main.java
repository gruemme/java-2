
public class Main {

	public static void main(String[] args) {
		Pair<Integer> p1 = new Pair<Integer>(4,2);
			
		Object x = p1.getA1();
		
		Pair<String> p2 = new Pair<String>("String1","String2");
		
		Integer o1 = p1.getA1();
		
		String s = p2.getA1();
		System.out.println(s);
		
	}
}
