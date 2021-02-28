package gerenciador.acoes;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;

public class RemoveEmpresa implements Executa {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String id = request.getParameter("id");

		Banco banco = new Banco();
		banco.remove(id);

		return "redirect:?acao=ListaEmpresas";
	}
}
