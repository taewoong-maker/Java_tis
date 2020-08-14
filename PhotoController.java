package net.tis.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tis.common.DB;
import net.tis.sql.GuestDTO;
import net.tis.sql.GuestSQL;

//@WebServlet("/PhotoController")
public class PhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public PhotoController() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet(1,2)");
//	request, response ��밡��
//	out, application, session �������� ��� �츮�� ���� ��üȭ �۾�
//	response.getWriter().append("Served at: ").append(request.getContextPath());
//	contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
		doUser(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doUser(request,response);
	}
	protected void doUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doUser(1,2)");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>PhotoController.java ���� 11:45 </h1>");
		out.println("<img src=images/aaa.gif>");
		
		//����
		String msg = " select count(*) as cnt from login where userid = ? and pwd = ?";
		Connection CN = DB.getConnection();
		GuestSQL gs = new GuestSQL();
		int Gtotal = gs.dbGtotal();
//		ArrayList<GuestDTO> LG = gs.dbSelect();
//		request.setAttribute("LG", LG);
		request.setAttribute("Gtotal", Gtotal);
		HttpSession hs = request.getSession();
		hs.setAttribute("naver", "sky");
//		PreparedStatement PST = new 
	}

}
