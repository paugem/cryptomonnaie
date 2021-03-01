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

	private static final long serialVersionUID = 1L;

	CurrencyServicesImp currencyServices = new CurrencyServicesImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<Currency> currencies = currencyServices.index();

		req.setAttribute("currencies", currencies);
		
		if (req.getParameter("error_message") != null && req.getParameter("error_message").equalsIgnoreCase("yes")) {
			req.setAttribute("error_message", "Impossible de supprimer une cryptomonnaie presente dans un avoir.");
		}

		req.getRequestDispatcher("/WEB-INF/currency_list.jsp").forward(req, resp);
	}
}
