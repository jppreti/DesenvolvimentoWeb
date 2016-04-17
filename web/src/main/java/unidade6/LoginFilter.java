package unidade6;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/Calculadora.jsp")
public class LoginFilter implements Filter {

    public LoginFilter() {    }

	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession sessao = ((HttpServletRequest)request).getSession(false);
		if (sessao!=null && sessao.getAttribute("login")!=null && sessao.getAttribute("login").equals(true)) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse)response).sendRedirect("LoginComCookieSessao.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {	}

}
