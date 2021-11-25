package com.arnav.verma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.arnav.verma.trains.Train;
import com.arnav.verma.hotels.Hotel;
import com.arnav.verma.packages.Package;

public class ActionDAO 
{
	private Connection con;

	public ActionDAO(Connection con) 
	{
		this.con = con;
	}
	public ArrayList<Flight> Search() throws SQLException 
	{
		ArrayList<Flight> list = new ArrayList<Flight>();
		ResultSet rs = null;
		String query = "select * from flights";
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
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
			list.add(fl);
		}
		return list;
	}
	public ArrayList<Flight> Search(String source, String Destination) throws SQLException
	{
		ArrayList<Flight> list = new ArrayList<Flight>();
		ResultSet rs = null;
		String query = "select * from flights where from_city = '"+source+"' and to_city = '"+Destination+"'";
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
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
			list.add(fl);
		}
		return list;
	}
	public ArrayList<Train> Searchtrains() throws SQLException 
	{
		ArrayList<Train> list = new ArrayList<Train>();
		ResultSet rs = null;
		String query = "select * from trains";
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
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
			list.add(tr);
		}
		return list;
	}
	public ArrayList<Train> Searchtrains(String source, String desti) throws SQLException 
	{
		ArrayList<Train> list = new ArrayList<Train>();
		ResultSet rs = null;
		String query = "select * from trains where from_city = '"+source+"' and to_city = '"+desti+"'";
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
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
			list.add(tr);
		}
		return list;
	}
	
	public void Booktrain(Train trbo, String name, String PNR, String classs, String date) throws SQLException
	{
		String query = "insert into bookedtrains values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);	
		pst.setString(1, trbo.getName());
		pst.setString(2, trbo.getSource());
		pst.setString(3, trbo.getDestination());
		pst.setString(4, trbo.getTrainid());
		pst.setString(5, trbo.getPrice());
		pst.setString(6, trbo.getTime());
		pst.setString(7, trbo.getDuration());
		pst.setString(8, classs);
		pst.setString(9, PNR);
		pst.setString(10, name);
		pst.setString(11, date);
		pst.executeUpdate();
	}
	public void Bookflight(Flight flbo, String name, String PNR, String classs, String date) throws SQLException
	{
		String query = "insert into bookedflights values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);	
		pst.setString(1, flbo.getName());
		pst.setString(2, flbo.getSource());
		pst.setString(3, flbo.getDestination());
		pst.setString(4, flbo.getFlightid());
		pst.setString(5, flbo.getPrice());
		pst.setString(6, flbo.getTime());
		pst.setString(7, flbo.getDuration());
		pst.setString(8, classs);
		pst.setString(9, PNR);
		pst.setString(10, name);
		pst.setString(11, date);
		pst.executeUpdate();
	}
	public void Bookhotel(Hotel htbo, String name, String PNR, int rooms, String checkin, String checkout) throws SQLException
	{
		String query = "insert into bookedhotels values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);	
		pst.setString(1, htbo.getName());
		pst.setString(2, htbo.getCity());
		pst.setInt(3, htbo.getPrice());
		pst.setInt(4, rooms);
		pst.setString(5, PNR);
		pst.setString(6, name);
		pst.setString(7, checkin);
		pst.setString(8, checkout);
		pst.executeUpdate();
	}
	public ArrayList<Hotel> Searchhotels() throws SQLException 
	{
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		ResultSet rs = null;
		String query = "select * from webhotels";
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
		while(rs.next())
		{
			Hotel ht = new Hotel();
			ht.setName(rs.getString("hotelname"));
			ht.setCity(rs.getString("city"));
			ht.setArea(rs.getString("area"));
			ht.setAddress(rs.getString("address"));
			ht.setPrice(rs.getInt("price"));
			ht.setAmenities(rs.getString("amenities"));
			ht.setRating(rs.getInt("ratings"));	
			list.add(ht);
		}
		return list;
	}
	public ArrayList<Hotel> Searchhotels(String city, String area, int range) throws SQLException 
	{
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		ResultSet rs = null;
		String query = "select * from webhotels where city = '"+city+"' and area = '"+area+"' and price < "+range;
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
		while(rs.next())
		{
			Hotel ht = new Hotel();
			ht.setName(rs.getString("hotelname"));
			ht.setCity(rs.getString("city"));
			ht.setArea(rs.getString("area"));
			ht.setAddress(rs.getString("address"));
			ht.setPrice(rs.getInt("price"));
			ht.setAmenities(rs.getString("amenities"));
			ht.setRating(rs.getInt("ratings"));	
			list.add(ht);
		}
		return list;
	}
	public ArrayList<Package> Searchpackages() throws SQLException 
	{
		ArrayList<Package> list = new ArrayList<Package>();
		ResultSet rs = null;
		String query = "select * from packages";
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
		while(rs.next())
		{
			Package pc = new Package();
			pc.setName(rs.getString("package_name"));
			pc.setCity(rs.getString("location"));
			pc.setHotel(rs.getString("hotel"));
			pc.setDuration(rs.getString("duration"));
			pc.setPrice(rs.getString("price"));
			pc.setDiscount(rs.getString("discount"));
			pc.setRemarks(rs.getString("remarks"));	
			list.add(pc);
		}
		return list;
	}
	public ArrayList<Hotel> Searchhotels(String city) throws SQLException 
	{
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		ResultSet rs = null;
		String query = "select * from webhotels where city = '"+city+"'";
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
		while(rs.next())
		{
			Hotel ht = new Hotel();
			ht.setName(rs.getString("hotelname"));
			ht.setCity(rs.getString("city"));
			ht.setArea(rs.getString("area"));
			ht.setAddress(rs.getString("address"));
			ht.setPrice(rs.getInt("price"));
			ht.setAmenities(rs.getString("amenities"));
			ht.setRating(rs.getInt("ratings"));	
			list.add(ht);
		}
		return list;
	}
	public void Bookpackage(Package pcbo, String name, String PNR) throws SQLException
	{
		String query = "insert into bookedpackages values(?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);	
		pst.setString(1, pcbo.getName());
		pst.setString(2, pcbo.getCity());
		pst.setString(3, pcbo.getPrice());
		pst.setString(4, pcbo.getHotel());
		pst.setString(5, pcbo.getDuration());
		pst.setString(6, name);
		pst.setString(7, PNR);
		pst.executeUpdate();
	}
	
	public void CancelBooking(String PNR) throws SQLException
	{
		String query1 = "DELETE FROM bookedhotels WHERE PNR = '"+PNR+"'";
		String query2 = "DELETE FROM bookedflights WHERE PNR = '"+PNR+"'";
		String query3 = "DELETE FROM bookedtrains WHERE PNR = '"+PNR+"'";
		String query4 = "DELETE FROM bookedpackages WHERE PNR = '"+PNR+"'";
		PreparedStatement pst1 = con.prepareStatement(query1);
		PreparedStatement pst2 = con.prepareStatement(query2);
		PreparedStatement pst3 = con.prepareStatement(query3);
		PreparedStatement pst4 = con.prepareStatement(query4);
		pst1.executeUpdate();
		pst2.executeUpdate();
		pst3.executeUpdate();
		pst4.executeUpdate();
	}
	
}
