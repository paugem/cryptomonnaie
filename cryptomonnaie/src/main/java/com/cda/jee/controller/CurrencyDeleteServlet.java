package com.cda.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.services.CurrencyServicesImp;

@WebServlet("/currency_delete.html")
public class CurrencyDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	CurrencyServicesImp currencyServices = new CurrencyServicesImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("id");
		int id = Integer.valueOf(idStr);
		
		currencyServices.delete(id);
		
		resp.sendRedirect("./currency_index.html");	}
}
