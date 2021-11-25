package com.arnav.verma.packages;

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
import com.arnav.verma.hotels.Hotel;

/**
 * Servlet implementation class Booedpackageserv
 */
@WebServlet("/Booedpackageserv")
public class Booedpackageserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booedpackageserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection con = null;
		ArrayList<Package> pcb = new ArrayList<Package>();
		
		ArrayList<String> name = new ArrayList<String>();		
		
		ArrayList<String> pnrs = new ArrayList<String>();
		
		
		try {
			con = DBConnection.MakeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		String query = "select * from bookedpackages";
		
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
				Package pc = new Package();
				pc.setName(rs.getString("package_name"));
				pc.setCity(rs.getString("location"));
				pc.setPrice(rs.getString("price"));
				pc.setDuration(rs.getString("duration"));
				pc.setHotel(rs.getString("hotel"));
				pcb.add(pc);
				
				name.add(rs.getString("passname"));
				
				pnrs.add(rs.getString("PNR"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("PCB", pcb);
		
		session.setAttribute("names", name);
		
		session.setAttribute("pnr", pnrs);
		
		response.sendRedirect("Cancelpackage.jsp");;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
