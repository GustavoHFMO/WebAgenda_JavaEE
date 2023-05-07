<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Cliente" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("contatos");
	
	/***
	for(int i = 0; i < lista.size(); i++){
		out.println(lista.get(i).getIdcon());
		out.println(lista.get(i).getNome());
		out.println(lista.get(i).getFone());
		out.println(lista.get(i).getEmail());
	}***/
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/FavIcon.png">
<link rel="stylesheet" href="style.css">

</head>

<body>
	
	<h1>Agenda de Contatos</h1>
	<a href="novoContato.html" class="Botao" href="">Novo contato</a>
	
	<table id="tabela">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>
			</tr>
		</thead>
		
		<tbody>
			<%for(int i = 0; i <lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getIdcon()%> </td>
					<td><%=lista.get(i).getNome()%> </td>
					<td><%=lista.get(i).getFone()%> </td>
					<td><%=lista.get(i).getEmail()%> </td>
				</tr>
			<% } %>
		</tbody>
		
	</table>
	
	
</body>

</html>
