package gerenciador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String data = request.getParameter("dataAbertura");
		
		Empresa empresa;
		try {
			empresa = new Empresa(UUID.randomUUID(), nome, new SimpleDateFormat("dd/MM/yyyy").parse(data));
			Banco banco = new Banco();
			banco.adiciona(empresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		response.sendRedirect("listaEmpresas");
	}
}
