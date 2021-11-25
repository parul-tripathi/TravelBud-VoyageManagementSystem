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
import com.arnav.verma.trains.Train;

/**
 * Servlet implementation class Hoteldetailserv
 */
@WebServlet("/Hoteldetailserv")
public class Hoteldetailserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hoteldetailserv() {
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
		String hotelname = request.getParameter("name");
		try {
			con = DBConnection.MakeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionDAO act = new ActionDAO(con);
		ArrayList<Hotel> ht= (ArrayList<Hotel>) session.getAttribute("Ht");
		Hotel htbo = null;
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
		response.sendRedirect("Hoteldetail.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
