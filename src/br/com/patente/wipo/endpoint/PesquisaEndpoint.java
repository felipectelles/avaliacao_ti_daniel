package br.com.patente.wipo.endpoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patente.wipo.controller.BuscaController;
import br.com.patente.wipo.controller.PatenteController;
import br.com.patente.wipo.model.Patente;

@WebServlet("/pesquisa")
public class PesquisaEndpoint extends HttpServlet{
	
	private PatenteController patenteController = new PatenteController();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/pesquisa.jsp");
		dispatcher.forward(req, resp);
	}

}
