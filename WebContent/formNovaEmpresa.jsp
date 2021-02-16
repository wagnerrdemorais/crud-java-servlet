<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
		<body>
		
			<form action="/gerenciador/novaEmpresa" method="POST">
				Nome: <input type="text" name="nome">
				Data abertura: <input type="text" name="dataAbertura">
				<input type="submit">
			</form>
		
		</body>
</html>