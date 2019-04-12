package com.jorgeg.vaquita;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ConfirmarHora extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hora = request.getParameter("hora");
		request.setAttribute("hora", hora);
		
		RequestDispatcher myDispatcher = request.getRequestDispatcher("/confirmacion.jsp");
		myDispatcher.forward(request, response);
	}

}
