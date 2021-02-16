package gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();

		String id = request.getParameter("id");

		Empresa empresa = banco.getEmpresa(id);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formEditaEmpresa.jsp");

		request.setAttribute("empresa", empresa);
		
		System.out.println(empresa.getNome());

		requestDispatcher.forward(request, response);

	}
}
