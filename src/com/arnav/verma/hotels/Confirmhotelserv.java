package com.arnav.verma.hotels;

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

import com.arnav.verma.ActionDAO;
import com.arnav.verma.DBConnection;
import com.arnav.verma.GeneratePNR;
import com.arnav.verma.trains.Train;

/**
 * Servlet implementation class Confirmhotelserv
 */
@WebServlet("/Confirmhotelserv")
public class Confirmhotelserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmhotelserv() {
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
		int rooms = (int) session.getAttribute("rooms");

		String checkin = (String)session.getAttribute("checkin");
		String checkout = (String)session.getAttribute("checkout");
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
		ArrayList<Hotel> ht= (ArrayList<Hotel>) session.getAttribute("Ht");
		Hotel htbo = (Hotel) session.getAttribute("bookedhotel");
		if(request.getParameter("bookthis") != null)
		{
			String hotelname = request.getParameter("name");
			for(Hotel htb:ht)
			{
				
				System.out.println(hotelname);
				if(htb.getName().equalsIgnoreCase(hotelname))
				{
					System.out.println("found");
					htbo = htb;
					break;
				}
			}
			session.setAttribute("bookedhotel", htbo);
			response.sendRedirect("Add_flight_booking_details/web/Addhoteldetails.jsp");
		}
		System.out.println("trbo"+htbo.getName());
		
		if(request.getParameter("details") != null)
		{
			passengername = request.getParameter("name");
			//rooms = request.getParameter("num");
			//classs = request.getParameter("Class");
			try {
				act.Bookhotel(htbo, passengername, PNR, rooms, checkin, checkout);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("rooms", rooms);
			session.setAttribute("name", passengername);
			session.setAttribute("chin", checkin);
			session.setAttribute("chout", checkout);
			session.setAttribute("pnr", PNR);
		}
		
		//System.out.println(passengername+" "+persons+" "+classs);
		//System.out.println("trbo"+trbo.getName());
	
		//System.out.println(flbo.getName());
		//String query = "insert into flights values('"+flbo.getName()+"','"+flbo.getSource()+"', '"+flbo.getDestination()+"','"+flbo.getFlightid()+"', '"+flbo.getPrice()+"', '"+flbo.getTime()+"', '"+flbo.getDuration()+"','"+classs+"','"+persons+"')";
		if(request.getParameter("details") != null)
		{
			response.sendRedirect("HotelBookingDone.jsp");
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
