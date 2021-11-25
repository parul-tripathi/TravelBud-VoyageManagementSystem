package com.arnav.verma;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Filterserv
 */
@WebServlet("/Filterserv")
public class Filterserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filterserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//was used when cities were added as filter but for that also flight serv is used..
		HttpSession session = request.getSession();
		//PrintWriter out = response.getWriter();
		Connection con = null;
		ArrayList<Flight> flights = null;
		String source = request.getParameter("fromcity");
		String desti = request.getParameter("tocity");
		try {
			con = DBConnection.MakeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		ActionDAO act = new ActionDAO(con);
		
		 try {
			flights = act.Search(source, desti);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("Fl", flights);
		response.sendRedirect("FlightBooking.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
