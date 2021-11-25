package com.arnav.verma;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cancelserv
 */
@WebServlet("/Cancelserv")
public class Cancelserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cancelserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PNR = request.getParameter("PNR");
		HttpSession session = request.getSession();
		System.out.println(PNR);
		//PrintWriter out = response.getWriter();
		Connection con = null;
		try {
			con = DBConnection.MakeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionDAO act = new ActionDAO(con);
		
		try {
			act.CancelBooking(PNR);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(request.getParameter("cancelflight") != null)
		{
			response.sendRedirect("BookedFlightserv");
		}
		if(request.getParameter("canceltrain") != null)
		{
			response.sendRedirect("Bookedtrainserv");
		}
		if(request.getParameter("cancelhotel") != null)
		{
			response.sendRedirect("Bookedhotelserv");
		}
		if(request.getParameter("cancelpackage") != null)
		{
			response.sendRedirect("Booedpackageserv");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
