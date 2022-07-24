import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageProviderTest {

	@Test
	public void testAddMessageThenGetMessage() {
		MessageProvider provider = new MessageProvider();
		provider.addMessage("one");
		Assertions.assertEquals("one", provider.getMessage());
	}

	@Test
	public void testGetMessageThenAddMessage() throws InterruptedException {
		MessageProvider provider = new MessageProvider();
		List<String> list = new ArrayList<>();
		new Thread(() -> list.add(provider.getMessage())).start();
		Thread.yield();
		provider.addMessage("one");
		while (list.isEmpty()) {
			System.out.println("yield...");
			Thread.yield();
		}
		Assertions.assertEquals("one", list.get(0));
	}

	private class Reader implements Runnable {

		private MessageProvider messageProvider;

		private String message;

		public Reader(MessageProvider messageProvider) {
			this.messageProvider = messageProvider;
		}

		public String getMessage() {
			return message;
		}

		@Override
		public void run() {
			message = messageProvider.getMessage();
		}

	}

	@Test
	public void testManyGetMessageThenAddManyMessage() throws InterruptedException {
		MessageProvider provider = new MessageProvider();
		List<Reader> list = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			Reader reader = new Reader(provider);
			list.add(reader);
			new Thread(reader).start();
		}
		Thread.yield();
		for (int i = 0; i < 10; i++) {
			provider.addMessage("" + i);
		}
		for (int i = 0; i < 10; i++) {
			while (null == list.get(i).getMessage()) {
				Thread.yield();
			}
			System.out.println(list.get(i).getMessage());
			Assertions.assertNotNull("i=" + i, list.get(i).getMessage());
		}
	}

}
