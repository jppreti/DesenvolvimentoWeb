package unidade2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet
public class ServletBasico implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("M�todo init executado!");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("M�todo service executado!");
	}

	@Override
	public void destroy() {
		System.out.println("M�todo destroy executado!");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
}

