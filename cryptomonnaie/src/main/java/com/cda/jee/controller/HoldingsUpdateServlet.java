package com.cda.jee.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Currency;
import com.cda.jee.model.Holding;
import com.cda.jee.services.HoldingsServicesImp;

@WebServlet("/holdings_update.html")
public class HoldingsUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HoldingsServicesImp holdingsServices = new HoldingsServicesImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("id");

		int id = Integer.valueOf(idStr);
		Holding holding = holdingsServices.read(id);

		req.setAttribute("holding", holding);
		req.getRequestDispatcher("/WEB-INF/holdings_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String nameCurrency = holdingsServices.read(id).getNameCurrency();
		String quantityStr = req.getParameter("quantity");
		String purchasePriceStr = req.getParameter("purchasePrice");
		String purchaseDateStr = req.getParameter("purchaseDate");
		

		// Check if every parameters has been completed
		if (nameCurrency == null || nameCurrency.isEmpty() || quantityStr == null || quantityStr.isEmpty()
				|| purchasePriceStr == null || purchasePriceStr.isEmpty()) {
			req.setAttribute("error_message", "La quantité, le prix et la date d'achatsont obligatoires.");
			doGet(req,resp);
			return;
		}

		// Check if the price is a number
		int quantity;
		float purchasePrice;
		try {
			quantity = Integer.parseInt(quantityStr);
			purchasePrice = Float.parseFloat(purchasePriceStr);
		} catch (NumberFormatException e) {
			req.setAttribute("error_message", "La quantité et le prix sont forcément des nombres.");
			doGet(req, resp);
			return;
		}

		// Check if the price and quantity aren't negative
		if (purchasePrice < 0 || quantity < 0) {
			req.setAttribute("error_message", "Le prix ne peut pas être négatif.");
			doGet(req, resp);
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
		
		Holding holding = new Holding(nameCurrency, quantity, purchasePrice, purchaseDate);
		holdingsServices.update(holding);

		resp.sendRedirect("./holdings_index.html");
	}
}
