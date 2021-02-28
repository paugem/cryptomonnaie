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

		String name = String.valueOf((String) req.getParameter("name"));
		String label = String.valueOf((String) req.getParameter("label"));
		String currentPriceStr = req.getParameter("currentPrice");

		// Check if every parameters has been completed
		if (name == null || name.isEmpty() || label == null || label.isEmpty() || currentPriceStr == null
				|| currentPriceStr.isEmpty()) {
			req.setAttribute("error_message", "Toutes les informations sont obligatoires.");
			req.getRequestDispatcher("/WEB-INF/currency_new.jsp").forward(req, resp);
			return;
		}
		
		// Check if the label has no more than 3 characters
		if (label.length() > 3) {
			req.setAttribute("error_message", "Le label ne doit pas dépasser 3 lettres.");
			req.getRequestDispatcher("/WEB-INF/currency_new.jsp").forward(req, resp);
			return;
		}

		// Check if the price is a number
		Float currentPrice;
		try {
			currentPrice = Float.parseFloat(currentPriceStr);
		} catch (NumberFormatException e) {
			req.setAttribute("error_message", "Le prix est forcément un nombre.");
			req.getRequestDispatcher("/WEB-INF/currency_new.jsp").forward(req, resp);
			return;
		}
		
		// Check if the price isn't negative
		if (currentPrice < 0) {
			req.setAttribute("error_message", "Le prix ne peut pas être négatif.");
			req.getRequestDispatcher("/WEB-INF/currency_new.jsp").forward(req, resp);
			return;
		}
		
		// Check if the name is already taken
		ArrayList<Currency> currencies = currencyServices.index();
		ArrayList<String> currenciesName = new ArrayList<String>();
		for(Currency currency : currencies) {
			currenciesName.add(currency.getNameCurrency());
		}
		if (currenciesName.contains(name)) {
			req.setAttribute("error_message", "Cette cryptomonnaie existe déjà.");
			req.getRequestDispatcher("/WEB-INF/currency_new.jsp").forward(req, resp);
			return;
		}

		Currency currency = new Currency(name, label, currentPrice);
		currencyServices.create(currency);

		resp.sendRedirect("./currency_index.html");
	}
}
