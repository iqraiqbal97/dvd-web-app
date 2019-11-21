package database;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Dvd;

public class DvdController {
	public static void main(String[] args) {
		
		myDAO dao = new myDAO();

		Dvd insert = new Dvd(20, "Harry Potter", "Fantasy", 2001);
		Dvd update = new Dvd(20, "Harry Potter", "XXXXX", 2001);
		Dvd delete = new Dvd(4, null, null, 0);

		
		try {
			dao.deleteDVD(delete);
//			dao.updateDVD(update);
//			dao.insertDVD(delete);
			
			//most flexible size 
			ArrayList<Dvd>allDvds = dao.getDVDs();
			
			for(Dvd d: allDvds) {
				System.out.println(d.getTitle());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
