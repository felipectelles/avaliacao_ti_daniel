package br.com.patente.wipo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.patente.wipo.dao.PatenteDao;
import br.com.patente.wipo.filter.PatenteFilter;
import br.com.patente.wipo.model.Patente;

public class PatenteController {

	PatenteDao patenteDao = new PatenteDao();

	public Patente save(HttpServletRequest req) {
		String numeroPublicacao = req.getParameter("numeroPublicacao");
		String dataPublicacaoString = req.getParameter("dataPublicacao");
		String numeroPedidoInternacional = req.getParameter("numeroPedidoInternacional");
		String requerentes = req.getParameter("requerentes");
		String titulo = req.getParameter("titulo");

		LocalDate dataPublicacao = LocalDate.parse(dataPublicacaoString);

		Patente patente = new Patente(numeroPublicacao, numeroPedidoInternacional, dataPublicacao,
				requerentes, titulo);

		return patenteDao.salvar(patente);
	}

	public List<Patente> getAllWithFiter(HttpServletRequest req) {
		String tipoFiltro = req.getParameter("tipoFiltro");
		String filtro = req.getParameter("filtro");
		PatenteFilter filter = new PatenteFilter(tipoFiltro, filtro);
		return patenteDao.findAllWithFilter(filter);
	}

}
