package br.com.patente.wipo;

public enum TipoFiltroEnum {
	NUMERO_PUBLICACAO("P", "Número de Publicação"), REQUERENTES("R", "Requerentes");

	private String id;
	private String descricao;

	TipoFiltroEnum(String id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static TipoFiltroEnum from(final String valor) {
		if (valor == null) {
			throw new IllegalArgumentException();
		}

		for (TipoFiltroEnum e : TipoFiltroEnum.values()) {
			if (valor.equalsIgnoreCase(e.getDescricao()) || valor.equalsIgnoreCase(e.getId())) {
				return e;
			}
		}

		final StringBuilder msg = new StringBuilder("");
		msg.append("Cannot parse into an element of TipoFiltroEnum: '");
		msg.append(valor);
		msg.append("'");

		throw new IllegalArgumentException(msg.toString());
	}

	public static TipoFiltroEnum fromId(final String id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}

		for (TipoFiltroEnum e : TipoFiltroEnum.values()) {
			if (id.equals(e.getId())) {
				return e;
			}
		}

		final StringBuilder msg = new StringBuilder("");
		msg.append("Cannot parse into an element of TipoFiltroEnum: '");
		msg.append(id);
		msg.append("'");

		throw new IllegalArgumentException(msg.toString());
	}

	@Override
	public String toString() {
		return this.descricao;
	}
}
