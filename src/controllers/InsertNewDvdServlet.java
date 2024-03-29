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

/**
 * Servlet implementation class InsertNewDvdServlet
 */
@WebServlet("/InsertNewDvdServlet")
public class InsertNewDvdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertNewDvdServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		int year = Integer.valueOf(request.getParameter("year"));

		Dvd dvd = new Dvd(999, title, genre, year);

		myDAO dao = new myDAO();

		try {
			dao.insertDVD(dvd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
