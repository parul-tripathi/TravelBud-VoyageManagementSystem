package com.arnav.verma.hotels;

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

import com.arnav.verma.DBConnection;
import com.arnav.verma.Flight;

/**
 * Servlet implementation class Bookedhotelserv
 */
@WebServlet("/Bookedhotelserv")
public class Bookedhotelserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookedhotelserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection con = null;
		ArrayList<Hotel> htb = new ArrayList<Hotel>();
		ArrayList<String> chin = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();		
		ArrayList<String> chout = new ArrayList<String>();
		ArrayList<String> pnrs = new ArrayList<String>();
		ArrayList<Integer> rooms = new ArrayList<Integer>();
		
		try {
			con = DBConnection.MakeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		String query = "select * from bookedhotels";
		
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
				Hotel ht = new Hotel();
				ht.setName(rs.getString("hotel_name"));
				ht.setCity(rs.getString("city"));
				ht.setPrice(rs.getInt("price"));
				htb.add(ht);
				chin.add(rs.getString("checkin_date"));
				name.add(rs.getString("passname"));
				chout.add(rs.getString("checkout_date"));
				pnrs.add(rs.getString("PNR"));
				rooms.add(rs.getInt("rooms"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("HTB", htb);
		session.setAttribute("chin", chin);
		session.setAttribute("names", name);
		session.setAttribute("chout", chout);
		session.setAttribute("pnr", pnrs);
		session.setAttribute("rooms", rooms);
		response.sendRedirect("CancelHotelbooking.jsp");;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
