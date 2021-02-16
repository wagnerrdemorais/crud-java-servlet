<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/editaEmpresa" var="editar"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
		<body>
		
			<form action="${editar}" method="POST">
			
				Nome: <input type="text" name="nome" value="${empresa.nome}">
				
				Data abertura: <input type="text" name="dataAbertura" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"> 
				
				<input hidden="true" type="text" name="id" value="${empresa.id}">
				
				<input type="submit">
			</form>
		
		</body>
</html>