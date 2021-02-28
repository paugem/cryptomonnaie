package com.cda.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Currency;
import com.cda.jee.services.CurrencyServicesImp;

@WebServlet("/currency_new.html")
public class CurrencyNewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	CurrencyServicesImp currencyServices = new CurrencyServicesImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/currency_new.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt((String)req.getParameter("id"));
		String name = String.valueOf((String)req.getParameter("name"));
		String label = String.valueOf((String)req.getParameter("label"));
		Float currentPrice = Float.parseFloat((String)req.getParameter("currentPrice"));
		
		Currency currency = new Currency(id, name, label, currentPrice);
		currencyServices.create(currency);
		
		resp.sendRedirect("./currency_index.html");
	}
}
