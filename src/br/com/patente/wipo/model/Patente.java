package br.com.patente.wipo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = Patente.TABLE)
public class Patente {

	protected static final String TABLE = "PATENTE";

	private static final String ID_COLUMN = "ID";
	private static final String NUM_PUB_COLUMN = "NUMERO_PUBLICACAO";
	private static final String NUM_PED_COLUMN = "NUMERO_PEDIDO_INTER";
	private static final String DT_PUB_COLUMN = "DATA_PUBLICACAO";
	private static final String REQ_COLUMN = "REQUERENTES";
	private static final String TIT_COLUMN = "TITULO";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID_COLUMN)
	private Long id;

	@NotNull
	@Column(name = NUM_PUB_COLUMN)
	private String numeroPublicacao;

	@NotNull
	@Column(name = NUM_PED_COLUMN)
	private String numeroPedidoInternacional;

	@NotNull
	@Column(name = DT_PUB_COLUMN)
	private LocalDate dataPublicacao;

	@NotNull
	@Column(name = REQ_COLUMN)
	private String requerentes;

	@NotNull
	@Column(name = TIT_COLUMN)
	private String titulo;

	public Patente() {
	}

	public Patente(String numeroPublicacao, String numeroPedidoInternacional, LocalDate dataPublicacao,
			String requerentes, String titulo) {
		this.numeroPublicacao = numeroPublicacao;
		this.numeroPedidoInternacional = numeroPedidoInternacional;
		this.dataPublicacao = dataPublicacao;
		this.requerentes = requerentes;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroPublicacao() {
		return numeroPublicacao;
	}

	public void setNumeroPublicacao(String numeroPublicacao) {
		this.numeroPublicacao = numeroPublicacao;
	}

	public String getNumeroPedidoInternacional() {
		return numeroPedidoInternacional;
	}

	public void setNumeroPedidoInternacional(String numeroPedidoInternacional) {
		this.numeroPedidoInternacional = numeroPedidoInternacional;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getRequerentes() {
		return requerentes;
	}

	public void setRequerentes(String requerentes) {
		this.requerentes = requerentes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return this.numeroPublicacao + "-" + this.numeroPedidoInternacional + "-" + this.dataPublicacao + "-"
				+ this.requerentes + "-" + this.titulo;
	}

}
