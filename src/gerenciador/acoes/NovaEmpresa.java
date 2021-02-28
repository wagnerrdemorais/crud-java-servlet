package gerenciador.acoes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class NovaEmpresa implements Executa {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String data = request.getParameter("dataAbertura");

		Empresa empresa;
		try {
			empresa = new Empresa(UUID.randomUUID(), nome, new SimpleDateFormat("dd/MM/yyyy").parse(data));
			Banco banco = new Banco();
			banco.adiciona(empresa);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		return "redirect:?acao=ListaEmpresas";
	}
}
