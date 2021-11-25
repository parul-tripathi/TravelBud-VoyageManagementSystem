package com.arnav.verma.trains;

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
 * Servlet implementation class Bookedtrainserv
 */
@WebServlet("/Bookedtrainserv")
public class Bookedtrainserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookedtrainserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection con = null;
		ArrayList<Train> trb = new ArrayList<Train>();
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
		String query = "select * from bookedtrains";
		
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
				Train tr = new Train();
				tr.setName(rs.getString("train_name"));
				tr.setSource(rs.getString("from_city"));
				tr.setTrainid(rs.getString("train_id"));
				tr.setDestination(rs.getString("to_city"));
				tr.setPrice(rs.getString("price"));
				tr.setTime(rs.getString("timing"));
				tr.setDuration(rs.getString("duration"));	
				trb.add(tr);
				date.add(rs.getString("train_date"));
				name.add(rs.getString("passname"));
				classs.add(rs.getString("class"));
				pnrs.add(rs.getString("PNR"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("TRB", trb);
		session.setAttribute("dates", date);
		session.setAttribute("names", name);
		session.setAttribute("clas", classs);
		session.setAttribute("pnr", pnrs);
		response.sendRedirect("Canceltrainbooking.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
