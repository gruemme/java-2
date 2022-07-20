package de.bredex.kurse.java2.jdbc;

import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain {

	public static void main(String[] args) throws SQLException {
		Uebung1 uebung1 = new Uebung1();
        uebung1.connect();
        
        uebung1.createDatabase();
        
        int person1ID = uebung1.insertPerson("Ford", "Harrison");
        int person2ID = uebung1.insertPerson("Fisher", "Carrie");
        int person3ID = uebung1.insertPerson("Hamill", "Mark");
        int person4ID = uebung1.insertPerson("Hauer", "Rutger");
        
        int seminar1ID = uebung1.insertSeminar("Acting for Beginners");
        int seminar2ID = uebung1.insertSeminar("Acting for Professionals");
        
        uebung1.assignToSeminar(seminar2ID, person1ID);
        uebung1.assignToSeminar(seminar2ID, person4ID);
        uebung1.assignToSeminar(seminar1ID, person2ID);
        uebung1.assignToSeminar(seminar1ID, person3ID);
        
        Object[] result = uebung1.getFirstResult("SELECT * FROM person WHERE last LIKE 'Ford'");
        for(Object o : result) {
        	System.out.print(o + " ");
        }
        System.out.println();
	}

}
