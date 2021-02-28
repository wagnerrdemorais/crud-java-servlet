<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/?acao=MostraEmpresa" var="linkMostra" />
<c:url value="/?acao=RemoveEmpresa" var="linkRemove" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Empresas</title>
</head>
<body>
	<c:import url="logoutParcial.jsp"/>

	Usuario Logado: ${usuarioLogado.login}

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome}<fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" /> <a
				href="${linkMostra}&id=${empresa.id}"> editar </a> <a
				href="${linkRemove}&id=${empresa.id}"> remover </a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>