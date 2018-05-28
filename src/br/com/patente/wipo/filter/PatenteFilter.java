package br.com.patente.wipo.filter;

public class PatenteFilter {

	private String tipoFiltro;
	private String filtro;

	public PatenteFilter() {
	}

	public PatenteFilter(String tipoFiltro, String filtro) {
		this.tipoFiltro = tipoFiltro;
		this.filtro = filtro;
	}

	public String getTipoFiltro() {
		return tipoFiltro;
	}

	public void setTipoFiltro(String tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
