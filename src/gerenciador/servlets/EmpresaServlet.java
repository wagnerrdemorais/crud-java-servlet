package gerenciador.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

@WebServlet("/Empresas")
public class EmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

//		Gson gson = new Gson();
//		String json = gson.toJson(empresas);
//		response.setContentType("application/json");
//		response.getWriter().print(json);

		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		String xml = xstream.toXML(empresas);

		response.setContentType("application/xml");
		response.getWriter().print(xml);
	}

}
