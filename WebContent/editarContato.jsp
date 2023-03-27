<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<h1>Editar contato</h1>

	<form method="get" action="update">

		<table>
			<tr><td><input class="Caixa" type="text" name="idcon"
					value="<%out.print(request.getAttribute("idcon"));%>"></td></tr>
					
			<tr><td><input class="Caixa" type="text" name="nome"
					value="<%out.print(request.getAttribute("nome"));%>"></td></tr>

			<tr><td><input class="Caixa" type="text" name="fone"
					value="<%out.print(request.getAttribute("fone"));%>"></td></tr>

			<tr><td><input class="Caixa" type="text" name="email"
					value="<%out.print(request.getAttribute("email"));%>"></td></tr>
		</table>

		<input class="Botao" type="submit" value="Salvar">
	</form>
</body>
</html>