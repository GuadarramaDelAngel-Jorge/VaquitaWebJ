package com.jorgeg.vaquita;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcesarOrden")
public class ProcesarOrden extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nombre = request.getParameter("nombre");
		String platillo = request.getParameter("platillo");
		String bebida = request.getParameter("bebida");
		String extra = request.getParameter("extra");
		String otros = request.getParameter("otros");
		
		request.setAttribute("nombre",nombre);
		request.setAttribute("platillo",platillo);
		request.setAttribute("bebida",bebida);
		request.setAttribute("extra",extra);
		request.setAttribute("otros",otros);
		
		RequestDispatcher myDispatcher = request.getRequestDispatcher("/confirmarPedido.jsp");
		myDispatcher.forward(request, response);
		
	}

}
