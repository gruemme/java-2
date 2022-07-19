

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Uebung1 {
	
	
    public int getMonthOfThirdDateAfter2000(List<LocalDate> dateList) {
        LocalDate dateAfter = LocalDate.of(1999, 12, 31);
    	
        Integer thirdMonth = dateList.stream()
        		.filter(d -> d.isAfter(dateAfter))        		
        		.map(d -> d.getMonthValue())
        		.sorted((m1,m2) -> {
        			if(m1 == m2) {
        				return 0;
        			}
        			if (m1 < m2) {
        				return -1;
        			}
        			return 1;
        		})
        		.distinct()
        		.skip(2)
        		.findFirst()
        		.get();
    	
    	return thirdMonth;        
    }
    
    public int getMonthOfThirdDateAfter2000_1(List<LocalDate> dateList) {
        LocalDate dateAfter = LocalDate.of(2000, 1, 1);
    	
        List<Integer> months = dateList.stream()
        		.filter(d -> {
        			System.out.println("1: " + d);
        			return true;
        		})
        		.filter(d -> d.isAfter(dateAfter))
        		.filter(d -> {
        			System.out.println("2: " + d);
        			return true;
        		})
        		.map(d -> d.getMonthValue())
        		.filter(d -> {
        			System.out.println("3: " + d);
        			return true;
        		})
        		.distinct()
        		.filter(d -> {
        			System.out.println("4: " + d);
        			return true;
        		})
        		.collect(Collectors.toList());
    	
    	return months.get(2);        
    }
    
    
    
    
}
