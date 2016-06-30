package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ClienteMB {

	private Cliente cliente = new Cliente();
	private String confirmarSenha;
	
	public String salvar() {
		if (cliente.getSenha().equals(confirmarSenha)) {
			Cliente.clientes.add(cliente);
			cliente = new Cliente();
			return "sucesso";
		} else {
			String msg = "As senhas não conferem!";
			FacesMessage fMsg = new FacesMessage(msg);
			FacesContext.getCurrentInstance()
				.addMessage("frmCliente", fMsg);
			return "falha";
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
}
