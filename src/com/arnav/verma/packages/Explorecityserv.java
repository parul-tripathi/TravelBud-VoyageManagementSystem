package com.arnav.verma.packages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Explorecityserv
 */
@WebServlet("/Explorecityserv")
public class Explorecityserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Explorecityserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String City = (String) session.getAttribute("city");
		if(City.equalsIgnoreCase("Goa"))
		{
			response.sendRedirect("Explorecities/Goa/goa_page/index.html");
		}
		if(City.equalsIgnoreCase("Mumbai"))
		{
			response.sendRedirect("Explorecities/mumbai/Mumbai/Mumbai_page/index.html");
		}
		if(City.equalsIgnoreCase("Jaipur"))
		{
			response.sendRedirect("Explorecities/Jaipur/Jaipur_page/index.html");
		}
		if(City.equalsIgnoreCase("Manali"))
		{
			response.sendRedirect("Explorecities/Manali/manali_page/index.html");
		}
		if(City.equalsIgnoreCase("Agra"))
		{
			response.sendRedirect("Explorecities/Agra/Agra_page/index.html");
		}
		if(City.equalsIgnoreCase("Kolkata"))
		{
			response.sendRedirect("Explorecities/Kolkata/kolkata_page/index.html");
		}
		if(City.equalsIgnoreCase("Munnar"))
		{
			response.sendRedirect("Explorecities/Munnar/munnar_page/index.html");
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
