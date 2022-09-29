package com.hsbc;

import java.io.*;
//import java.net.http.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
//import java.io.BufferedReader;
import java.net.http.*;


//@WebServlet("/controllerServlet")
@WebServlet("/controller")
public class CostController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");		
//		System.out.println("In Get");
		PrintWriter out = resp.getWriter();
		HelperGetJSON hp = new HelperGetJSON();
		out.println(hp.getJson());
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HelperStoreData hs = new HelperStoreData();
//		System.out.println("In POST");
		String uname = req.getParameter("uname");
//		System.out.println("After getting parameter");
//		System.out.println(uname);
		String city = req.getParameter("city");
		int dist = Integer.parseInt(req.getParameter("distance"));
//		System.out.println(dist);
		int Summary = dist*10 ;
		
		String output = hs.storeData(uname,city,dist,Summary);
		PrintWriter out = resp.getWriter();
		out.println( "<h1>" +output+"</h1>");
		
	}
	
	
}
