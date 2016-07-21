package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Login2MB { 

	private Cliente cliente;
	private String senha;
	private String msg;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String login() {
		if (cliente.getSenha().equals(senha))
			return "sucesso";
			
		msg="Login ou Senha Inválidos!";
		FacesContext
			.getCurrentInstance()
			.addMessage("frmLogin",
					    new FacesMessage(msg));
		return "falha";
	}

	public String getMsg() {
		return msg;
	}
	
}
