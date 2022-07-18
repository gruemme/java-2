
public class NewClass extends OldClass {
	@Override
	public void doNewStuff() {
		System.out.println("Do New stuff");
	}
	
	// Error here with @Override
	public void secondNewStuff() {
		System.out.println("Do even more New stuff");	
	}
}
