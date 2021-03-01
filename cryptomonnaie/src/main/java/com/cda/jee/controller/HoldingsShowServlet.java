package com.cda.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.model.Holding;
import com.cda.jee.services.HoldingsServicesImp;

@WebServlet("/holdings_show.html")
public class HoldingsShowServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	HoldingsServicesImp holdingsServices = new HoldingsServicesImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("id");
		int id = Integer.valueOf(idStr);
		Holding holding = holdingsServices.read(id);

		req.setAttribute("holding", holding);

		req.getRequestDispatcher("/WEB-INF/holdings_show.jsp").forward(req, resp);
	}
	
}
