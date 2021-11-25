package com.arnav.verma;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Confirmbookingserv
 */
@WebServlet("/Confirmbookingserv")
public class Confirmbookingserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmbookingserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String passengername = null;
		String persons = null;
		String classs = null;
		String date = (String)session.getAttribute("date");
		//System.out.println(persons+" "+ classs);
		GeneratePNR obj =new GeneratePNR();
		String PNR = obj.randomAlphaNumeric(11);
		Connection con = null;
		try {
			con = DBConnection.MakeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionDAO act = new ActionDAO(con);
		ArrayList<Flight> fl= (ArrayList<Flight>) session.getAttribute("Fl");
		Flight flbo = (Flight) session.getAttribute("bookedflight");
		if(request.getParameter("bookthis") != null)
		{
			for(Flight flb:fl)
			{
				String flightname = request.getParameter("name");
				System.out.println(flightname);
				if(flb.getName().equalsIgnoreCase(flightname))
				{
					System.out.println("found");
					flbo = flb;
					break;
				}
			}
			session.setAttribute("bookedflight", flbo);
			response.sendRedirect("Add_flight_booking_details/web/Addflightdetails.jsp");
		}
		
		System.out.println("flbo"+flbo.getName());
		
		if(request.getParameter("details") != null)
		{
			passengername = request.getParameter("name");
			persons = request.getParameter("num");
			classs = request.getParameter("Class");
			try {
				act.Bookflight(flbo, passengername, PNR, classs, date);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("city", flbo.getDestination());
			session.setAttribute("name", passengername);
			session.setAttribute("class", classs);
			session.setAttribute("pnr", PNR);
		}
		
		System.out.println(passengername+" "+persons+" "+classs);
		System.out.println("flbo"+flbo.getName());
		
		
		
		//System.out.println(flbo.getName());
		//String query = "insert into flights values('"+flbo.getName()+"','"+flbo.getSource()+"', '"+flbo.getDestination()+"','"+flbo.getFlightid()+"', '"+flbo.getPrice()+"', '"+flbo.getTime()+"', '"+flbo.getDuration()+"','"+classs+"','"+persons+"')";
		if(request.getParameter("details") != null)
		{
			response.sendRedirect("BookingDone.jsp");
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
