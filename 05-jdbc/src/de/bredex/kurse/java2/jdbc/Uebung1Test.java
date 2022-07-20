package de.bredex.kurse.java2.jdbc;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Uebung1Test {
    
    private static Uebung1 uebung1;
    
    @BeforeAll
    public static void connect() throws SQLException {
        uebung1 = new Uebung1();
        uebung1.connect();
    }
    
    @AfterAll
    public static void disconnect() throws SQLException {
        uebung1.disconnect();
    }
    
    @BeforeEach
    public void reInitDatabase() throws SQLException {
        uebung1.clearDatabase();
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
    }
    
    @Test
    public void testHarrisonFord() throws SQLException {
        Object[] result = uebung1.getFirstResult("SELECT * FROM person WHERE last LIKE 'Ford'");
        Assertions.assertEquals("Harrison", result[2]);
    }

    @Test
    public void testHamillBeginner() throws SQLException {
        Object[] resultSeminar = uebung1.getFirstResult("SELECT id FROM seminar WHERE title LIKE '%Beginners'");
        Object[] resultPerson = uebung1.getFirstResult("SELECT * FROM person WHERE last LIKE 'Hamill' AND first LIKE 'Mark'");
        
        Object[] resultAttendee = uebung1.getFirstResult("SELECT COUNT(*) FROM attendees WHERE seminarid = " + resultSeminar[0] + " AND personid = " + resultPerson[0]);
        
        Assertions.assertEquals(Long.valueOf(1), resultAttendee[0]);
    }
}
