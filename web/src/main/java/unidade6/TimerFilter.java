package unidade6;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class TimerFilter implements Filter {

	ServletContext context = null;

	public TimerFilter() {
	}

	public void init(FilterConfig config) throws ServletException {
		this.context = config.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		long inicio = System.currentTimeMillis();
		chain.doFilter(request, response);
		long fim = System.currentTimeMillis();

		String nome = "";
		if (request instanceof HttpServletRequest) {
			nome = ((HttpServletRequest) request).getRequestURI();
		}
		context.log(nome + ": " + (fim - inicio) + "ms");
	}
	
	public void destroy() {	}
}
