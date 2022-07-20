
public class StopWatch implements Runnable {
	private String name;
	
	public StopWatch(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		int minutes = 0;
		int seconds = 0;
		
		for(int i = 0;i < 10000;++i) {
			try {
				System.out.format("%s: %02d:%02d%n",this.name, minutes, seconds);
				++seconds;
				if(seconds >= 60) {
					++minutes;
					seconds = 0;
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
