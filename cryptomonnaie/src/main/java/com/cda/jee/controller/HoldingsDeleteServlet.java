package com.cda.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.jee.services.HoldingsServicesImp;

@WebServlet("/holdings_delete.html")
public class HoldingsDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HoldingsServicesImp holdingsServices = new HoldingsServicesImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("id");
		int id = Integer.valueOf(idStr);

		holdingsServices.delete(id);

		resp.sendRedirect("./holdings_index.html");
	}
}
