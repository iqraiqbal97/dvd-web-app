//CONTROLLER
package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.myDAO;
import models.Dvd;

@WebServlet("/getDVDServlet")
public class getDVDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDVDServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		myDAO dao = new myDAO();
		
		try {
			dao.getDVDs();
			//Make an araylist
			ArrayList<Dvd> allDvds = dao.getDVDs();
			
			//to pass thing to the view
			request.setAttribute("dvds", allDvds);
			request.getRequestDispatcher("home.jsp")
			.forward(request, response);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
