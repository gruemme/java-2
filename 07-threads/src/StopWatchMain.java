
public class StopWatchMain {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new StopWatch("t1"));
		Thread t2 = new Thread(new StopWatch("t2"));
		
		t1.start();
		t2.start();
				
		t1.join(); // Wait for t1
		t2.join(); // Wait for t2
		
		System.out.println("Main process has ended");
	}

}
