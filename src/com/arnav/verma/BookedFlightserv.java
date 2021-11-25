package com.arnav.verma;

import java.io.IOException;
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
 * Servlet implementation class BookedFlightserv
 */
@WebServlet("/BookedFlightserv")
public class BookedFlightserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookedFlightserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection con = null;
		ArrayList<Flight> flb = new ArrayList<Flight>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();		
		ArrayList<String> classs = new ArrayList<String>();
		ArrayList<String> pnrs = new ArrayList<String>();
		try {
			con = DBConnection.MakeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		String query = "select * from bookedflights";
		
		if(con != null)
		{
			Statement st;
			try {
				st = con.createStatement();
				rs = st.executeQuery(query);
			} catch (SQLException e) {e.printStackTrace();}	
		}
		
		try {
			while(rs.next())
			{
				Flight fl = new Flight();
				fl.setName(rs.getString("flight_name"));
				fl.setSource(rs.getString("from_city"));
				fl.setFlightid(rs.getString("flight_id"));
				fl.setDestination(rs.getString("to_city"));
				fl.setPrice(rs.getString("price"));
				fl.setTime(rs.getString("timing"));
				fl.setDuration(rs.getString("duration"));	
				flb.add(fl);
				date.add(rs.getString("flight_date"));
				name.add(rs.getString("passname"));
				classs.add(rs.getString("class"));
				pnrs.add(rs.getString("PNR"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("FLB", flb);
		session.setAttribute("dates", date);
		session.setAttribute("names", name);
		session.setAttribute("clas", classs);
		session.setAttribute("pnr", pnrs);
		response.sendRedirect("Cancelbooking.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
