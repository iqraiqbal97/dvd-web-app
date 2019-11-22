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


@WebServlet("/DeleteDVDServlet")
public class DeleteDVDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteDVDServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myDAO dao = new myDAO();
		
		int ID = Integer.valueOf(request.getParameter("ID"));
		
		Dvd dvd = new Dvd(ID, null, null, 0);
		try {
			dao.deleteDVD(dvd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
