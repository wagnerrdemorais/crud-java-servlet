package gerenciador.acoes;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Usuario;

public class Login implements Executa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Banco banco = new Banco();
		Optional<Usuario> usuario = banco.getUsuario(login, senha);
		
		if(usuario.isPresent()) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario.get());
			
			return "redirect:?acao=ListaEmpresas";
		}else {
			return "redirect:?acao=LoginForm";
		}
		
	}
}
