package unidade2;

import javax.servlet.*;
import java.io.IOException;

public class ServletBasico implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MŽtodo init executado!");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("MŽtodo service executado!");
	}

	@Override
	public void destroy() {
		System.out.println("MŽtodo destroy executado!");
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

