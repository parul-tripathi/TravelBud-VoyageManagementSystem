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

/**
 * Servlet implementation class TrainServ
 */
@WebServlet("/TrainServ")
public class TrainServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainServ() {
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
		ArrayList<Train> trains = null;
		
		System.out.println(request.getParameter("trains"));
		
		try {
			con = DBConnection.MakeConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionDAO act = new ActionDAO(con);
		
			try {
				trains = act.Searchtrains();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<Train> drop = trains;
			session.setAttribute("trlist", drop);
		
		
		 if(request.getParameter("filter") != null)
		{
			String date = request.getParameter("date");
			session.setAttribute("date", date);
			System.out.println(date);
			String source = request.getParameter("fromcity");
			String desti = request.getParameter("tocity");
			 try {
				 trains = act.Searchtrains(source, desti);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 	session.setAttribute("Tr", trains);
				response.sendRedirect("TrainBooking.jsp");
		}
		 else
				response.sendRedirect("TRAIN_ticket_booking/web/trainselect.jsp");
		
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
