package unidade7;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

@WebListener
public class RequestsCriados implements ServletRequestListener {

	public int quantidade = 0;
	ServletContext context = null;
	
    public RequestsCriados() { }

    public void requestDestroyed(ServletRequestEvent evt) {  }

    public void requestInitialized(ServletRequestEvent evt) {
    	quantidade++;
    	if (context == null) {
    		evt.getServletContext().setAttribute("RequestsCriados", this);
    	}
    }	
}
