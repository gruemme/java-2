

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Uebung1Test {
    
    private static final String[] TESTTEXT_LINES = new String[] {
        "Dies ist eine Testdatei.",
        "Mit einer zweiten Zeile...",
        "...und einer dritten Zeile."
        };
    
    @Test
    public void testReadLinesFromInputStream() {
        String testText = Stream.of(TESTTEXT_LINES).
                reduce((s1, s2) -> s1 + System.getProperty("line.separator") + s2).
                get();
        ByteArrayInputStream stream = new ByteArrayInputStream(testText.getBytes());
        try {
            List<String> readLines = new Uebung1().readLinesFromInputStream(stream);
            Assertions.assertArrayEquals( TESTTEXT_LINES, readLines.toArray(),
            		"Zeilen aus InputStream nicht korrekt gelesen");
        } catch (IOException e) {
            Assertions.fail("Es trat eine unerwartete IOException auf");
        }
    }

}
