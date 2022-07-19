

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Uebung1Test {
    
    @Test
    public void testGetMonthOfThirdDateAfter2000() {
        LocalDate[] dateArray = new LocalDate[] {
                LocalDate.of(2000, 12, 15),
                LocalDate.of(1998, 8, 1),
                LocalDate.of(2000, 4, 30),
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2000, 8, 1), // <-- result
                LocalDate.of(2000, 1, 2),
                LocalDate.of(1999, 8, 1)
        };
        int result = new Uebung1().getMonthOfThirdDateAfter2000(Arrays.asList(dateArray));
        Assertions.assertEquals(8, result);
    }

}
