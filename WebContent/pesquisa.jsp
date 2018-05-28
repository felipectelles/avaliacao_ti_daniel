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
<title>Pesquisa Patente</title>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	$(function(e) {

		var tipoFiltro;
		$('input[type="radio"]').click(function() {
			if ($(this).is(':checked')) {
				tipoFiltro = $(this).val();
			}
		});

		$("form").on("submit", function(e) {
			e.preventDefault();
		});
		$("#patente-table").hide();
		$("#botao-pesquisa").click(buscarPatentes);

		function buscarPatentes() {

			console.log("tipoFiltro", tipoFiltro);

			if (tipoFiltro) {
				var filtro = $("#filtro").val();

				var dados = {
					filtro : filtro,
					tipoFiltro : tipoFiltro
				};

				$.get("http://localhost:9090/patente-wipo/patente", dados,
						preencheTable).fail(function() {
					setTimeout(function() {
					}, 2000);
				}).always(function() {
				});
			}
		}

		function preencheTable(data) {
			$("#patente-table tr").remove();
			if (data.patentes.length > 0) {
				$("#patente-table").show();
				criaLinhasTabela(data.patentes);
				$("#patente-table").show();
			} else {
				$("#patente-table").hide();
			}
		}

		function criaLinhasTabela(patentes) {
			var novaLinha = $("<tr>");
			var cols = "";
			cols += '<th>Número de Publicação</th>';
			cols += '<th>Número do Pedido Internacional</th>';
			cols += '<th>Data do Pedido</th>';
			cols += '<th>Requerentes</th>';
			cols += '<th>Título</th>';
			novaLinha.append(cols);
			$("#tabela-patentes").append(novaLinha);

			patentes.forEach(function(patente) {
				var novaLinha = $("<tr>");
				var cols = "";
				cols += '<td>' + patente.numeroPublicacao + '</td>';
				cols += '<td>' + patente.numeroPedidoInternacional + '</td>';
				cols += '<td>' + patente.dataPublicacao.day + '/'
						+ patente.dataPublicacao.month + '/'
						+ patente.dataPublicacao.year + '</td>';
				cols += '<td>' + patente.requerentes + '</td>';
				cols += '<td>' + patente.titulo + '</td>';
				novaLinha.append(cols);
				$("#tabela-patentes").append(novaLinha);
			});
		}

	});
</script>


</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
		class="navbar-brand" href="#">Daniel<br />Legal & Ip Strategy
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">Cadastro
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="#">Pesquisa<span class="sr-only">(current)</span></a></li>
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
		<legend> Patente </legend>
		<div class="row">
			<div class="col-md-12">
				<form>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<input class="form-control" type="text" id="filtro"
									name="filtro" autofocus placeholder="Pesquisar..." />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="control-label" for="tipoFiltro"> <b>Pesquisar
									por:</b>
							</label>
						</div>

						<div class="form-group col-md-12">
							<label class="radio-inline"> <input type="radio"
								name="tipoFiltro" id="tipoFiltro" value="P" required="true">
								Número de
								Publicação&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							</label> <label class="radio-inline"> <input type="radio"
								name="tipoFiltro" id="tipoFiltro" value="R" required="true">
								Requerentes
							</label>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<button type="submit" class="btn btn-primary"
								name="botao-pesquisa" id="botao-pesquisa">Pesquisar</button>
						</div>
						<div class="col-md-2">
							<a class="btn btn-secondary"
								href="${pageContext.request.contextPath}/">Voltar</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<br /> <br />
		<div class="row" id="patente-table">
			<div class="col-md-12">
				<fieldset>
					<legend> Resultado </legend>
					<div class="table-responsive">
						<table id="tabela-patentes"
							class="table table-striped table-bordered table-hover table-grid">
							<tbody>

							</tbody>
						</table>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>