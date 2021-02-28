package gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/") configurado no web.xml
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("AutorizacaoFilter");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String acao = request.getParameter("acao");

		boolean usuarioNaoLogado = req.getSession().getAttribute("usuarioLogado") == null;
		boolean acaoProtegida = acao.equals("LoginForm") || acao.equals("Login");

		if (usuarioNaoLogado && !acaoProtegida) {
			res.sendRedirect("?acao=LoginForm");
			return;
		}

		chain.doFilter(request, response);
	}

}
