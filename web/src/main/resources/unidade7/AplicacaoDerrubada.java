package unidade7;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AplicacaoDerrubada implements ServletContextListener {

    public AplicacaoDerrubada() { }

    public void contextInitialized(ServletContextEvent evt) {  }

    public void contextDestroyed(ServletContextEvent evt) {
    	System.out.print("QUANTIDADE DE REQUISICOES ATENDIDAS: ");
    	System.out.println(((RequestsCriados)evt.getServletContext().getAttribute("RequestsCriados")).quantidade);
    }
	
}
