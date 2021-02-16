package gerenciador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaEmpresasServlet", urlPatterns = { "/listaEmpresas" })
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");

		request.setAttribute("empresas", empresas);
		requestDispatcher.forward(request, response);
	}
}
