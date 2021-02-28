package gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.acoes.Executa;

public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

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

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

	}

}
