package unidade4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("nomeUsuario","");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		
		cookie = new Cookie("login","");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		
		response.sendRedirect("LoginComCookieSessao.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnLogin")!=null && request.getParameter("btnLogin").equalsIgnoreCase("entrar")) {
			if (request.getParameter("txtLogin").equals("joao") && request.getParameter("txtSenha").equals("123")) {
				
				Cookie cookie = new Cookie("nomeUsuario","Joao Paulo Delgado Preti");
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
				
				cookie = new Cookie("login",request.getParameter("txtLogin"));
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
				
				request.getSession().setAttribute("login", true);
			}
		}
		
		if (request.getParameter("btnLogin")!=null && request.getParameter("btnLogin").equalsIgnoreCase("sair")) {
			request.getSession().invalidate();
		}
		response.sendRedirect("LoginComCookieSessao.jsp");
	}

}
