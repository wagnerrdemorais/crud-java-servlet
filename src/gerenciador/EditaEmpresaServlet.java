package gerenciador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editaEmpresa")
public class EditaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Banco banco = new Banco();
			String id = request.getParameter("id");
			Empresa empresa = banco.getEmpresa(id);

			String nome = request.getParameter("nome");
			String data = request.getParameter("dataAbertura");
			
			empresa.setNome(nome);
			empresa.setDataAbertura(new SimpleDateFormat("dd/MM/yyyy").parse(data));
			
			System.out.println(empresa.getNome());
			
			banco.edita(empresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		response.sendRedirect("listaEmpresas");
	}

}
