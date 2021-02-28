package gerenciador.acoes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class MostraEmpresa implements Executa {
	RequestDispatcher requestDispatcher;

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();

		String id = request.getParameter("id");
		Empresa empresa = banco.getEmpresa(id).orElse(new Empresa());

		request.setAttribute("empresa", empresa);

		return "forward:/formEditaEmpresa.jsp";
	}
}
