package unidade7;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ListenerMB {

	public String getTotalSessionCount() {
		return getContadorSessao().totalSessionCount+"";
	}
	
	public String getCurrentSessionCount() {
		return getContadorSessao().currentSessionCount+"";
	}
	
	public String getMaxSessionCount() {
		return getContadorSessao().maxSessionCount+"";
	}
	
	private ContadorSessao getContadorSessao() {
		return (ContadorSessao) FacesContext.getCurrentInstance()
				.getExternalContext().getApplicationMap()
				.get("contadorSessao");
	}
	
}
