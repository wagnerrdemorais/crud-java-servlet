<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/" var="linkNova" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa</title>
</head>
<body>
	<c:import url="logoutParcial.jsp"/>
	
	<form action="${linkNova }" method="POST">
		Nome: <input type="text" name="nome"> Data abertura: <input
			type="text" name="dataAbertura"> <input type="hidden"
			name="acao" value="NovaEmpresa" /> <input type="submit">
	</form>
</body>
</html>