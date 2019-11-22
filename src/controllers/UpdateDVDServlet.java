package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.myDAO;
import models.Dvd;

@WebServlet("/UpdateDVDServlet")
public class UpdateDVDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateDVDServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int ID = Integer.valueOf(request.getParameter("ID"));
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		int year = Integer.valueOf(request.getParameter("year"));

		Dvd dvd = new Dvd(ID, title, genre, year);

		myDAO dao = new myDAO();
		
		try {
			dao.updateDVD(dvd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
