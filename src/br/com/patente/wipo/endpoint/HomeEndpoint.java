package br.com.patente.wipo.endpoint;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patente.wipo.controller.BuscaController;

@WebServlet("/")
public class HomeEndpoint extends HttpServlet {

	private BuscaController buscaController = new BuscaController();

	/*
	 * Método responsável por retornar a tela inicial da aplicação
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
		dispatcher.forward(req, resp);
	}

	/*
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String resultadoBusca = buscaController.buscar(req);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.append(resultadoBusca);
		out.close();
	}

}