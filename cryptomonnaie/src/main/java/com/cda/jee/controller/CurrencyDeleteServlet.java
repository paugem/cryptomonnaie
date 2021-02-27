package com.cda.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Currency;
import com.cda.jee.services.CurrencyServicesImp;

@WebServlet("/currency_delete.html")
public class CurrencyDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CurrencyServicesImp currencyServices = new CurrencyServicesImp();

		String idStr = req.getParameter("id");
		int id = Integer.valueOf(idStr);
		
		currencyServices.delete(id);
		
		req.getRequestDispatcher("/WEB-INF/currency_index.jsp").forward(req, resp);
	}
}
