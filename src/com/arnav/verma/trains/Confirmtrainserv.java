package com.arnav.verma.trains;

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
 * Servlet implementation class Confirmtrainserv
 */
@WebServlet("/Confirmtrainserv")
public class Confirmtrainserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmtrainserv() {
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
		ArrayList<Train> tr= (ArrayList<Train>) session.getAttribute("Tr");
		Train trbo = (Train) session.getAttribute("bookedtrain");
		if(request.getParameter("bookthis") != null)
		{
			for(Train trb:tr)
			{
				String trainname = request.getParameter("name");
				System.out.println(trainname);
				if(trb.getName().equalsIgnoreCase(trainname))
				{
					System.out.println("found");
					trbo = trb;
					break;
				}
			}
			session.setAttribute("bookedtrain", trbo);
			response.sendRedirect("Add_train_booking_details/web/Addtraindetails.jsp");
		}
		
		System.out.println("trbo"+trbo.getName());
		
		if(request.getParameter("details") != null)
		{
			passengername = request.getParameter("name");
			persons = request.getParameter("num");
			classs = request.getParameter("Class");
			try {
				act.Booktrain(trbo, passengername, PNR, classs, date);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("city", trbo.getDestination());
			session.setAttribute("name", passengername);
			session.setAttribute("class", classs);
			session.setAttribute("pnr", PNR);
			
		}
		
		System.out.println(passengername+" "+persons+" "+classs);
		System.out.println("trbo"+trbo.getName());
	
		//System.out.println(flbo.getName());
		//String query = "insert into flights values('"+flbo.getName()+"','"+flbo.getSource()+"', '"+flbo.getDestination()+"','"+flbo.getFlightid()+"', '"+flbo.getPrice()+"', '"+flbo.getTime()+"', '"+flbo.getDuration()+"','"+classs+"','"+persons+"')";
		if(request.getParameter("details") != null)
		{
			response.sendRedirect("TrainBookingDone.jsp");
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
