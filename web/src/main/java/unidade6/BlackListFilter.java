package unidade6;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class BlackListFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean maliciosa = false;
		
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String nome = (String) e.nextElement();
			String valor = request.getParameter(nome);
			if (valor.toUpperCase().contains("DELETE"))
				maliciosa = true;
		}
		
		if (maliciosa)
			response.getWriter().print("Requisição Maliciosa!");
		else
			chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
