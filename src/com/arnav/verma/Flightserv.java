package com.arnav.verma;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Flightserv
 */
@WebServlet("/Flightserv")
public class Flightserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Flightserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Connection con = null;
		ArrayList<Flight> flights = null;
		ArrayList<String> cities = new ArrayList<String>();
		cities.add("Goa");
		cities.add("Agra");
		cities.add("Manali");
		cities.add("Jaipur");
		cities.add("Mumbai");
		cities.add("Munnar");
		cities.add("Kolkata");
		session.setAttribute("cities", cities);
		
		System.out.println(request.getParameter("flight"));
			
			try {
				con = DBConnection.MakeConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		ActionDAO act = new ActionDAO(con);
		
			try {
				flights = act.Search();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<Flight> drop = flights;
			session.setAttribute("list", drop);
			session.setAttribute("Fl", flights);
		
		if(request.getParameter("filter") != null)
		{
			String date = request.getParameter("date");
			session.setAttribute("date", date);
			System.out.println(date);
			String source = request.getParameter("fromcity");
			String desti = request.getParameter("tocity");
			 try {
				 flights = act.Search(source, desti);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 session.setAttribute("Fl", flights);
			 response.sendRedirect("FlightBooking.jsp");
		}
		
		else
			response.sendRedirect("flight_ticket_booking/web/flightselect.jsp");
		
		try {
			DBConnection.CloseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
