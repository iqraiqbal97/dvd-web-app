package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Dvd;

public class myDAO 
{
	//Load the driver, coonect to db
	
	private Connection getConnection()
	{
		Connection conn = null; 
		
		try {
			//Load the driver that we neeed
			Class.forName("org.sqlite.JDBC");
			
			//URL for the database location
			String url = "jdbc:sqlite:/Users/iqraiqbal/Downloads/dvd.sqlite";
			
			//Initialise the conn object
			conn = DriverManager.getConnection(url);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Return conn object
		return conn;
		
	}
	
	//Making it DYNAMIC
	public 	ArrayList<Dvd> getDVDs() throws SQLException {

		ArrayList<Dvd> allDvds = new ArrayList<>();
		
		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		String query = "SELECT * FROM collection;";

		System.out.println(query);

		// Code that executes the query - i.e runs in
		ResultSet rs = statement.executeQuery(query);

		// While you got another row keep the while loop going - that's all next does
		while (rs.next()) {
		int id = rs.getInt("ID");
		String title = rs.getString("Title");
		String genre = rs.getString("Genre");
		int year = rs.getInt("Year");
		
		Dvd dvd = new Dvd(id, title, genre, year);
		allDvds.add(dvd);

		System.out.println(id + " " + title + " " + genre + " " + year);
		}
		return allDvds;
		}
	
	public void insertDVD(Dvd dvd) throws SQLException
	{
		Connection connection = getConnection();
		Statement statement  = connection.createStatement();
		
		String querry1 = "INSERT INTO collection (ID,Title,Genre,Year)" + 
		"VALUES ("+dvd.getId()+", '"+dvd.getTitle()+"', '"+dvd.getGenre()+"', "+dvd.getYear()+");" ;
	
		System.out.println(querry1);
	
		statement.executeUpdate(querry1);
		System.out.println("Done");
	}

	public void updateDVD(Dvd dvd) throws SQLException
	{
		Connection connection = getConnection();
		Statement statement  = connection.createStatement();
		
		String sql = "UPDATE collection " + 
				"SET Title = '"+dvd.getTitle()+"', Genre = '"+dvd.getGenre()+"', Year = "+dvd.getYear()+"" + 
				" WHERE ID = "+dvd.getId()+";";
		
		System.out.println(sql);
	
		statement.executeUpdate(sql);
		System.out.println("Done");
	}
	
	public void deleteDVD(Dvd dvd) throws SQLException
	{
		Connection connection = getConnection();
		Statement statement  = connection.createStatement();
		
		String querry1 = "DELETE FROM collection WHERE ID = "+dvd.getId()+";";
	
		System.out.println(querry1);
	
		statement.executeUpdate(querry1);
		System.out.println("Done");
	}

}
