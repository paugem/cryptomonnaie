package com.cda.jee.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Holding;
import com.cda.jee.services.HoldingsServicesImp;

@WebServlet("/holdings_index.html")
public class HoldingsListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HoldingsServicesImp holdingsServices = new HoldingsServicesImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<Holding> holdings = holdingsServices.index();

		req.setAttribute("holdings", holdings);
		req.setAttribute("totalDelta", Holding.getTotalDelta());
		

		req.getRequestDispatcher("/WEB-INF/holdings_list.jsp").forward(req, resp);
	}
}
