package gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.acoes.Executa;

@WebServlet("/")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String fqn = "gerenciador.acoes." + acao;
		
		try {
			@SuppressWarnings("deprecation")
			Executa executar = (Executa) Class.forName(fqn).newInstance();
			String executa = executar.executa(request, response);

			String action = executa.split(":")[0];
			String sendTo = executa.split(":")[1];

			if (action.equals("forward")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view" + sendTo);
				requestDispatcher.forward(request, response);
			} else if (action.equals("redirect")) {
				response.sendRedirect(sendTo);
			}

		} catch ( ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

	}
}
