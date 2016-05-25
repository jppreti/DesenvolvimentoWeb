package unidade2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet
public class ServletBasico implements Servlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Método init executado!");
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("Método service executado!");
	}

	public void destroy() {
		System.out.println("Método destroy executado!");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}
}

