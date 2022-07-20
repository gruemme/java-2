

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Uebung2Test {
    
    @Test
    public void testSmallDirectorySize() throws IOException {
        Uebung2 uebung2 = new Uebung2();
        testDirectorySize(uebung2.getSmallDirectoryPath());
    }
    
    @Test
    public void testBigDirectorySize() throws IOException {
        Uebung2 uebung2 = new Uebung2();
        testDirectorySize(uebung2.getBigDirectoryPath());
    }
    
    private void testDirectorySize(String directoryPath) throws IOException {
        Uebung2 uebung2 = new Uebung2();
        
        long systime1 = System.currentTimeMillis();
        long size1 = uebung2.getDirectorySizeWithIO(directoryPath);
        long systime2 = System.currentTimeMillis();
        long size2 = uebung2.getDirectorySizeWithNIO(directoryPath);
        long systime3 = System.currentTimeMillis();
        
        Assertions.assertEquals(size1, size2, "Die Groessenmessungen wichen ab");
        long duration1 = systime2 - systime1;
        long duration2 = systime3 - systime2;
        System.out.println("Die Messung (" + directoryPath + " = " + size1 + "Bytes) dauerte: " + duration1 + " bzw. " + duration2 + " ms");
    }
    
}
