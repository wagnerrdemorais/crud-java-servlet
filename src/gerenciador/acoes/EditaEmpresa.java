package gerenciador.acoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class EditaEmpresa implements Executa{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		executar(request, response);
		return "redirect:?acao=ListaEmpresas";
	}

	private void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Banco banco = new Banco();
			String id = request.getParameter("id");
			Empresa empresa = banco.getEmpresa(id).orElse(new Empresa());

			String nome = request.getParameter("nome");
			String data = request.getParameter("dataAbertura");

			empresa.setNome(nome);
			empresa.setDataAbertura(new SimpleDateFormat("dd/MM/yyyy").parse(data));

			System.out.println(empresa.getNome());

			banco.edita(empresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
	}
}