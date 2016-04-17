package unidade2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletContador extends HttpServlet {

	private int qtdeChamadas = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		qtdeChamadas++;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<h1>Servlet Contador:</h1><br /><br />");
		out.print("<p>Qtde. de chamadas a este Servlet: " + qtdeChamadas + "</p>");
		out.print("</html>");
	}
}

