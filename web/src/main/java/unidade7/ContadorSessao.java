package unidade7;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ContadorSessao implements HttpSessionListener {
	public int totalSessionCount = 0;
	public int currentSessionCount = 0;
	public int maxSessionCount = 0;
	public ServletContext context = null;
	
	public void sessionCreated(HttpSessionEvent evt) {
		totalSessionCount++;
		currentSessionCount++;
		if (currentSessionCount > maxSessionCount) {
			maxSessionCount = currentSessionCount;
		}
		if (context == null) {
			storeInServletContext(evt);
		}
	}

	private void storeInServletContext(HttpSessionEvent evt) {
		HttpSession sessao = evt.getSession();
		context = sessao.getServletContext();
		context.setAttribute("contadorSessao", this);
	}

	public void sessionDestroyed(HttpSessionEvent evt) {
		currentSessionCount--;
	}
}
















