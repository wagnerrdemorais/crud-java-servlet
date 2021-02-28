<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/" var="login" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${login}" method="POST">
		Login: <input type="text" name="login"> Senha: <input
			type="password" name="senha"> <input type="hidden"
			name="acao" value="Login"> <input type="submit">
	</form>
</body>
</html>