package com.arnav.verma.packages;

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
import com.arnav.verma.Flight;
import com.arnav.verma.GeneratePNR;

/**
 * Servlet implementation class Packageserv
 */
@WebServlet("/Packageserv")
public class Packageserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Packageserv() {
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
		
		String persons = null;
		String passengername = null;
		
		//System.out.println(request.getParameter("flight"));
			
			try {
				con = DBConnection.MakeConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			GeneratePNR obj =new GeneratePNR();
			String PNR = obj.randomAlphaNumeric(11);
			
			
		ActionDAO act = new ActionDAO(con);
		ArrayList<Package> pac = null;
		try {
			pac = act.Searchpackages();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Package pcbo = (Package) session.getAttribute("bookedpackage");
		if(request.getParameter("bookthis") != null)
		{
			
			String packagename = request.getParameter("package");
			for(Package pcb:pac)
			{
				
				System.out.println(packagename);
				if(pcb.getName().equalsIgnoreCase(packagename))
				{
					System.out.println("found");
					pcbo = pcb;
					break;
				}
			}
			
			
			persons = request.getParameter("num");
			session.setAttribute("city", pcbo.getCity());
			session.setAttribute("bookedpackage", pcbo);
			response.sendRedirect("Add_flight_booking_details/web/Addpackagedetails.jsp");
		}
		
		
		
		else if(request.getParameter("details") != null)
		{
			passengername = request.getParameter("name");
			
			try {
				act.Bookpackage(pcbo, passengername, PNR);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.setAttribute("name", passengername);
			session.setAttribute("pnr", PNR);
		}
	
		if(request.getParameter("details") != null)
		{
			response.sendRedirect("packagebookingdone.jsp");
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
