package com.conversor.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calcular")
public class ConversorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConversorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String chamada = "";
		int celsius, fahrenheit, total = 0;
		Integer number = 0;
		
		// Verifica a exce��o caso n�o seja inserido o valor no campo input. 
		try {
			number = Integer.parseInt(request.getParameter("valor"));
		} catch (Exception e) {
			RequestDispatcher view = request.getRequestDispatcher("inputvazio.jsp");
			view.forward(request, response);
		}
		
		// Verifica a exce��o se um dos campos foi selecionado.
		try {
			if(tipo.equals("fahtocel")) {
				celsius = ((number - 32) * 5) / 9;
				total = celsius;
				chamada = "O resultado da convers�o de Fahrenheit para Celsius �: ";
			}else if(tipo.equals("celtofah")) {
				fahrenheit = ((number * 9) / 5) + 32;
				total = fahrenheit;
				chamada = "O resultado da convers�o de Celsius para Fahrenheit �: ";
			}
		}catch (Exception e) {
			RequestDispatcher view = request.getRequestDispatcher("selecaovazia.jsp");
			view.forward(request, response);
		} 
		
		// Printa na tela o resultado da convers�o.
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()){
            out.println("<DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado da soma</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/errorpages.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<section class=\"corpo\">");
            out.println("<h1>" + chamada + " " + total + "</h1>");
            out.println("<button onclick=\"location.href='index.jsp'\" type=\"button\">Realize Outra Convers�o</button>");
            out.println("</section>");
            out.println("</body>");
            out.println("</html>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
