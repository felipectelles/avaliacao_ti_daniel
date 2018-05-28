<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<title>Cadastro</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#botao-salvar").hide();
		$("#botao-cadastro").click(buscarPatente);

		function buscarPatente() {

			var numeroProcesso = $("#numero-processo").val();

			var dados = {
				numeroProcesso : numeroProcesso
			};

			//passando objeto como segundo parametro
			$.post("http://localhost:9090/patente-wipo/", dados,
					preenchePatente).fail(function() {
				$("#erro").toggle();
				setTimeout(function() {
					$("#botao-salvar").hide();
				}, 2000);
			}).always(function() {
				//$("#spinner").toggle();
			});
		}

		function preenchePatente(data) {

			var html = $.parseHTML(data);

			var numeroPublicacao = $(data).find('#detailPCTtableWO').text();

			$("#numeroPublicacao").val(numeroPublicacao);

			var numeroPedidoInternacional = $(data).find('#detailPCTtableAN')
					.text();

			$("#numeroPedidoInternacional").val(numeroPedidoInternacional);

			var dataPublicacaoNaoFormatada = $(data).find(
					'#detailPCTtablePubDate').text();

			var arrayData = dataPublicacaoNaoFormatada.split('.');

			var dataPublicacao = arrayData[2] + '-' + arrayData[1] + '-'
					+ arrayData[0];

			$("#dataPublicacao").val(dataPublicacao);

			var requerentes = $(data).find('#PCTapplicants').text();

			console.log("requerentes ", requerentes);
			$("#requerentes").val(requerentes);

			var titulo = $('<div/>').append(data).find('.PCTtitle').text();

			console.log("titulo ", titulo);
			$("#titulo").text(titulo);

			if (titulo != "" && numeroPublicacao !== ""
					&& numeroPedidoInternacional !== ""
					&& dataPublicacaoNaoFormatada !== "" && requerentes !== "") {
				$("#botao-salvar").show();
			}

		}

	});
</script>


</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
		class="navbar-brand" href="#">Daniel<br/>Legal & Ip Strategy</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">Cadastro
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/pesquisa">Pesquisa</a></li>
			</li>
		</ul>
	</div>
	</nav>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Prova Prática</h1>
			<p class="lead">TI - JAVA</p>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form action="${pageContext.request.contextPath}/patente"
					method="post">
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label" for="numero-processo"><b>Número
										do Processo</b></label> <input class="form-control" type="text"
									id="numero-processo" name="numero-processo" autofocus
									placeholder="Buscar..." />
							</div>
							<button type="button" class="btn btn-secondary"
								name="botao-cadastro" id="botao-cadastro">Buscar</button>
						</div>
						<div class="col-md-8">
							<fieldset>
								<legend>Patente</legend>

								<div class="form-group">
									<label for="numeroPublicacao">Número de Publicação</label> <input
										type="text" class="form-control" id="numeroPublicacao"
										name="numeroPublicacao" required="true" readonly>
								</div>

								<div class="form-group">
									<label for="numeroPedidoInternacional">Número do Pedido
										Internacional</label> <input type="text" class="form-control"
										id="numeroPedidoInternacional"
										name="numeroPedidoInternacional" required="true" readonly>
								</div>

								<div class="form-group">
									<label for="dataPublicacao">Data de Publicação</label> <input
										type="date" class="form-control" id="dataPublicacao"
										name="dataPublicacao" required="true" readonly>
								</div>

								<div class="form-group">
									<label for="requerentes">Requerentes</label>
									<textarea rows="4" class="form-control" id="requerentes"
										name="requerentes" required="true" readonly></textarea>
								</div>

								<div class="form-group">
									<label for="titulo">Título</label>
									<textarea rows="4" class="form-control" id="titulo"
										name="titulo" required="true" readonly></textarea>
								</div>
							</fieldset>
							<button type="submit" id="botao-salvar" class="btn btn-primary">Salvar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>