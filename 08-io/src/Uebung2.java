

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Uebung2 {
    
    public String getSmallDirectoryPath() {
        return "data";
    }
    
    public String getBigDirectoryPath() {
        return "..";
    }
    
    public long getDirectorySizeWithIO(String directoryPath) {
    	File dir = new File(directoryPath);
    	File[] filesInDir = dir.listFiles();
    	
    	long sumSizes = 0;
    	for(File file: filesInDir) {
    		if(!file.isDirectory()) {
        		sumSizes += file.length();
    		}
    	}
    	
//    	sumSizes = Stream.of(filesInDir)
//    		.filter(f -> !f.isDirectory())
//    		.mapToLong(f -> f.length())
//    		.sum();
    	
        return sumSizes;
    }
    
    public long getDirectorySizeWithNIO(String directoryPath) {
    	Path dir = Paths.get(directoryPath);
    	
    	long sumSizes = 0;
    	
    	try {
			sumSizes = Files.list(dir)
				.filter(p -> !Files.isDirectory(p))
				.mapToLong(p -> {
					try {
						return Files.size(p);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 0;
				})
				.sum();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return sumSizes;
    }

}
