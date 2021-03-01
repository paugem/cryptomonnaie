package com.cda.jee.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Currency;
import com.cda.jee.model.Holding;
import com.cda.jee.services.CurrencyServicesImp;
import com.cda.jee.services.HoldingsServicesImp;

@WebServlet("/holdings_new.html")
public class HoldingsNewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CurrencyServicesImp currencyServices = new CurrencyServicesImp();
	HoldingsServicesImp holdingsServices = new HoldingsServicesImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Currency> currencies = currencyServices.index();

		req.setAttribute("currencies", currencies);

		req.getRequestDispatcher("/WEB-INF/holdings_new.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nameCurrency = req.getParameter("nameCurrency");
		String quantityStr = req.getParameter("quantity");
		String purchasePriceStr = req.getParameter("purchasePrice");
		String purchaseDateStr = req.getParameter("purchaseDate");

		// Check if every parameters has been completed
		if (nameCurrency == null || nameCurrency.isEmpty() || quantityStr == null || quantityStr.isEmpty()
				|| purchasePriceStr == null || purchasePriceStr.isEmpty() || purchaseDateStr == null
				|| purchaseDateStr.isEmpty()) {
			req.setAttribute("error_message", "Toutes les informations sont obligatoires.");
			req.getRequestDispatcher("/WEB-INF/holdings_new.jsp").forward(req, resp);
			return;
		}

		// Check if the prices and quantity are numbers
		int quantity;
		float purchasePrice;
		try {
			quantity = Integer.parseInt(quantityStr);
			purchasePrice = Float.parseFloat(purchasePriceStr);

		} catch (NumberFormatException e) {
			req.setAttribute("error_message", "La quantité et le prix sont forcément des nombres.");
			req.getRequestDispatcher("/WEB-INF/holdings_new.jsp").forward(req, resp);
			return;
		}

		// Check if the prices and quantity aren't negative
		if (quantity < 0 || purchasePrice < 0) {
			req.setAttribute("error_message", "La quantité et le prix ne peuvent pas être négatif.");
			req.getRequestDispatcher("/WEB-INF/holdings_new.jsp").forward(req, resp);
			return;
		}

		// Check if the purchase date is a date
		Date purchaseDate;
		try {
			purchaseDate = Date.valueOf(purchaseDateStr);
		} catch (Exception e) {
			req.setAttribute("error_message", "Le format de la date est AAAA-MM-JJ.");
			req.getRequestDispatcher("/WEB-INF/holdings_new.jsp").forward(req, resp);
			return;
		}

		// Check if the name is a currency
		ArrayList<Currency> currencies = currencyServices.index();
		ArrayList<String> currenciesName = new ArrayList<String>();
		for (Currency currency : currencies) {
			currenciesName.add(currency.getNameCurrency());
		}
		if (!currenciesName.contains(nameCurrency)) {
			req.setAttribute("error_message", "Cette cryptomonnaie n'existe pas.");
			req.getRequestDispatcher("/WEB-INF/holdings_new.jsp").forward(req, resp);
			return;
		}
		
		// Check if the name is already taken
		ArrayList<Holding> holdings = holdingsServices.index();
		ArrayList<String> holdingsCurrencyName = new ArrayList<String>();
		for (Holding holding : holdings) {
			holdingsCurrencyName.add(holding.getNameCurrency());
		}
		if (holdingsCurrencyName.contains(nameCurrency)) {
			req.setAttribute("error_message", "Un avoir avec cette cryptomonnaie existe déjà.");
			req.getRequestDispatcher("/WEB-INF/holdings_new.jsp").forward(req, resp);
			return;
		}
		
		

		Holding holding = new Holding(nameCurrency, quantity, purchasePrice, purchaseDate);
		holdingsServices.create(holding);

		resp.sendRedirect("./holdings_index.html");
	}
}
