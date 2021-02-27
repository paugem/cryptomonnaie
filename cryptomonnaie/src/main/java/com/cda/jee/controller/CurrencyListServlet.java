package com.cda.jee.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Currency;
import com.cda.jee.services.CurrencyServicesImp;

@WebServlet("/currency_index.html")
public class CurrencyListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CurrencyServicesImp currencyServices = new CurrencyServicesImp();
		
		ArrayList<Currency> currencies = currencyServices.index();
		
		req.setAttribute("currencies", currencies);
		
		req.getRequestDispatcher("/WEB-INF/currency_list.jsp").forward(req, resp);
	}
}
