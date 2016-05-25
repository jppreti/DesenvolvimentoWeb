package unidade2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")

public class ServletTestaRequisicao extends HttpServlet {

	public ServletTestaRequisicao() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StringBuffer saida = new StringBuffer();
		saida.append("<html>");
		saida.append("<h1>Cabeçalhos</h1><br />");
		Enumeration cabecalhos = request.getHeaderNames();
		while (cabecalhos.hasMoreElements()) {
			String cabecalho = (String) cabecalhos.nextElement();
			saida.append("<p>" + cabecalho + ": "
					+ request.getHeader(cabecalho) + "</p>");
		}
		saida.append("<br />");

		saida.append("<h1>Parametros</h1><br />");
		Enumeration parametros = request.getParameterNames();
		while (parametros.hasMoreElements()) {
			String parametro = (String) parametros.nextElement();
			saida.append("<p>" + parametro + ": "
					+ request.getParameter(parametro) + "</p>");
		}
		saida.append("<br />");

		saida.append("");
		saida.append("</html>");
		PrintWriter out = response.getWriter();
		out.print(saida);
	}
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}














