package com.arnav.verma.hotels;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arnav.verma.ActionDAO;
import com.arnav.verma.DBConnection;
import com.arnav.verma.Flight;

/**
 * Servlet implementation class Viewhotelserv
 */
@WebServlet("/Viewhotelserv")
public class Viewhotelserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewhotelserv() {
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		ArrayList<Hotel> hotels = null;
		String city = null;
		String checkout = null;
		String checkin = null;
		String area = null;
		int rooms = 1;
		int range = 20000;
		ArrayList<String> cities = new ArrayList<String>();
		
		
		System.out.println("in viewhotels servlet");
		System.out.println(request.getParameter("searchhotel"));
		
		try {
			con = DBConnection.MakeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionDAO act = new ActionDAO(con);
		
		try {
			hotels = act.Searchhotels();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("Ht", hotels);
		
		if(request.getParameter("searchhotel") != null)
		{
			city = request.getParameter("city");
			session.setAttribute("city", city);
			checkout = request.getParameter("checkout");
			checkin = request.getParameter("checkin");
			float days = 0;
			try {
				LocalDateTime chin = LocalDateTime.parse(checkin, dtf);
			    LocalDateTime chout = LocalDateTime.parse(checkout, dtf);
				days = Duration.between(chin, chout).toDays();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			area = request.getParameter("area");
			rooms = Integer.parseInt(request.getParameter("rooms"));
			range = Integer.parseInt(request.getParameter("range"));
			System.out.println(city+" "+checkin+checkout+area+rooms+range+" "+days);
			 try {
				 hotels = act.Searchhotels(city, area, range);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 
			for(Hotel htb:hotels)
			{
				 htb.setPrice(htb.getPrice()*rooms);
			}
			 
			 session.setAttribute("Ht", hotels);
			 response.sendRedirect("Viewhotels.jsp");
			 session.setAttribute("rooms", rooms);
			 session.setAttribute("checkin", checkin);
			 session.setAttribute("checkout", checkout);
			
		}
		
		else
			response.sendRedirect("HOTEL_BOOKING/web/index.jsp");
		
		try {
			DBConnection.CloseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
