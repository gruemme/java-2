import java.util.Date;

public class UseDepricated {
	
	void exampleUseageOfDepricated() {
		Date date = new Date();
		int day = date.getDate();
	}
	
	void useOldStuff() {
		OldClass.doOldStuff();
		// migrate to OldClass.doNewStuff();
	}
}
