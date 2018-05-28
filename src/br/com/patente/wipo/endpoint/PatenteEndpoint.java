package br.com.patente.wipo.endpoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonConverter;

import br.com.patente.wipo.controller.PatenteController;
import br.com.patente.wipo.model.Patente;

@WebServlet("/patente")
public class PatenteEndpoint extends HttpServlet {

	private PatenteController patenteController = new PatenteController();

	/*
	 * Método responsável por receber um objeto do tipo patente e salvá-lo no
	 * banco de dados
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Patente patente = patenteController.save(req);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
		dispatcher.forward(req, resp);
	}

	/*
	 * Método responsável por realizar a busca de patentes com ou sem filtro
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("application/json;charset=UTF-8");

        ServletOutputStream out = resp.getOutputStream();

        List<Patente> patentes = patenteController.getAllWithFiter(req);

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(patentes);

        out.print(output);
		out.close();
	}

}