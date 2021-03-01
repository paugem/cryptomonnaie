package com.cda.jee.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Holding;
import com.cda.jee.services.CurrencyServicesImp;
import com.cda.jee.services.HoldingsServicesImp;

@WebServlet("/currency_delete.html")
public class CurrencyDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HoldingsServicesImp holdingsServices = new HoldingsServicesImp();
	CurrencyServicesImp currencyServices = new CurrencyServicesImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("id");
		int id = Integer.valueOf(idStr);
		String currencyName = currencyServices.read(id).getNameCurrency();

		ArrayList<Holding> holdings = holdingsServices.index();
		for (Holding holding : holdings) {
			if (holding.getNameCurrency().contains(currencyName)) {
				resp.sendRedirect("./currency_index.html?error_message=yes");
				return;
			}
		} 
		
		currencyServices.delete(id);

		resp.sendRedirect("./currency_index.html");
	}
}
