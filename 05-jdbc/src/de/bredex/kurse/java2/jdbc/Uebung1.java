package de.bredex.kurse.java2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Uebung1 {

	private Connection connection;
	private int nextPersonTableId = 1;
	private int nextSeminarTableId = 1;

	public void connect() throws SQLException {
		// Treiber: org.h2.Driver
		DriverManager.registerDriver(new org.h2.Driver());
		connection = DriverManager.getConnection("jdbc:h2:./test", "sa", "");
	}

	public void disconnect() throws SQLException {
		connection.close();
	}

	public void clearDatabase() throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("drop table if exists attendees, seminar, person");
		statement.close();
	}

	public void createDatabase() throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("create table person(id int primary key, last varchar(255), first varchar(255))");
		statement.executeUpdate("create table seminar(id int primary key, title varchar(255))");
		statement.executeUpdate("create table attendees(seminarid int, personid int)");
		statement.close();
	}

	public int insertPerson(String last, String first) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("insert into person values (?, ?, ?)");
		preparedStatement.setInt(1, nextPersonTableId);
		preparedStatement.setString(2, last);
		preparedStatement.setString(3, first);
		preparedStatement.executeUpdate();

		return nextPersonTableId++;
	}

	public int insertSeminar(String title) throws SQLException {
		
		PreparedStatement preparedStatement = connection.prepareStatement("insert into seminar values (?, ?)");
		preparedStatement.setInt(1, nextSeminarTableId);
		preparedStatement.setString(2, title);
		preparedStatement.executeUpdate();

		return nextSeminarTableId++;
	}

	public void assignToSeminar(int seminarID, int personID) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("insert into attendees values (?, ?)");
		preparedStatement.setInt(1, seminarID);
		preparedStatement.setInt(2, personID);
		
		preparedStatement.executeUpdate();
	}

	public Object[] getFirstResult(String selectSQL) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(selectSQL);

		int numberOfColumns = resultSet.getMetaData().getColumnCount();
		Object[] firstRowOfResult = new Object[numberOfColumns];
		resultSet.next(); // Go to the first row

		for (int i = 1; i < (numberOfColumns + 1); ++i) {
			firstRowOfResult[i - 1] = resultSet.getObject(i);
		}

		resultSet.close();
		statement.close();

		return firstRowOfResult;
	}
}
