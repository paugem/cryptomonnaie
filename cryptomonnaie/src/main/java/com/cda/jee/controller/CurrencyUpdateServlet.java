package com.cda.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Currency;
import com.cda.jee.services.CurrencyServicesImp;

@WebServlet("/currency_update.html")
public class CurrencyUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CurrencyServicesImp currencyServices = new CurrencyServicesImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idStr = req.getParameter("id");
		
		int id = Integer.valueOf(idStr);
		Currency currency = currencyServices.read(id);

		req.setAttribute("currency", currency);
		req.getRequestDispatcher("/WEB-INF/currency_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = "";
		String label = "";
		String currentPriceStr = req.getParameter("currentPrice");

		System.out.println(currentPriceStr);
		System.out.println(id);
		
		// Check if the price has been completed
		if (currentPriceStr == null || currentPriceStr.isEmpty()) {
			req.setAttribute("error_message", "Le prix est obligatoire.");
			doGet(req,resp);
			return;
		}
		
		
		// Check if the price is a number
		Float currentPrice;
		try {
			currentPrice = Float.parseFloat(currentPriceStr);
		} catch (NumberFormatException e) {
			req.setAttribute("error_message", "Le prix est forcément un nombre.");
			doGet(req,resp);
			return;
		}
		
		// Check if the price is negative
		if (currentPrice < 0) {
			req.setAttribute("error_message", "Le prix ne peut pas être négatif.");
			doGet(req,resp);
			return;
		}

		Currency currency = new Currency(id, name, label, currentPrice);
		currencyServices.update(currency);

		resp.sendRedirect("./currency_index.html");
	}
}
