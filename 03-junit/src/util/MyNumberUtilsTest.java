package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyNumberUtilsTest {
	
	private MyNumberUtils numberUtils;
	@BeforeEach
	void initNumberUtilsObject() {
		numberUtils = new MyNumberUtils();	
		System.out.println("Created new NumberUtils object");
	}

	@Test
	void testIsEvenGiven10() {

		boolean actualValue = numberUtils.isEven(10);
		
		assertTrue(actualValue);
	}

	@Test
	void testIsNotEvenGiven13() {
		boolean actualValue = numberUtils.isEven(13);
		
		assertFalse(actualValue);
	}
}
