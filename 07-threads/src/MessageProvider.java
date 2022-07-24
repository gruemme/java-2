public class MessageProvider {

	private String savedMessage;

	public synchronized void addMessage(String message) {
		System.out.println("Thread " + Thread.currentThread().getId() + ": addMessage() enter");
		while (savedMessage != null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Thread " + Thread.currentThread().getId() + ": was interrupted");
			}
		}
		savedMessage = message;

		this.notifyAll();
		System.out.println("Thread " + Thread.currentThread().getId() + ": addMessage() return");
	}

	public synchronized String getMessage() {
		System.out.println("Thread " + Thread.currentThread().getId() + ": getMessage() enter");
		while (savedMessage == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Thread " + Thread.currentThread().getId() + ": was interrupted");
			}
		}
		String temp = savedMessage;
		savedMessage = null;
		this.notifyAll();

		System.out.println("Thread " + Thread.currentThread().getId() + ": getMessage() return");
		return temp;
	}
}
