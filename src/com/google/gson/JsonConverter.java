package com.google.gson;

import java.util.List;

import br.com.patente.wipo.model.Patente;

public class JsonConverter {

	private final Gson gson;

	public JsonConverter() {

		gson = new GsonBuilder().create();
	}

	public String convertToJson(List<Patente> patentes) {

		JsonArray jarray = gson.toJsonTree(patentes).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("patentes", jarray);

		return jsonObject.toString();
	}
}
