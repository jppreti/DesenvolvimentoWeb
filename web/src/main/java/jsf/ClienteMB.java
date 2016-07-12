package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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
			FacesContext.getCurrentInstance().addMessage("frmCliente", fMsg);
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

	public String resetarSenha() {
		SimpleEmail email = new SimpleEmail();

		try {
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication("seu_nome_de_usuario", "sua_senha");
			email.setSSL(true);
			email.addTo("para_quem_enviara_email"); // pode ser qualquer um
													// email
			email.setFrom("seu_email_gmail"); // aqui necessita ser o email que
												// voce fara a autenticacao
			email.setSubject("Teste");
			email.setMsg("Mensagem Testando");
			email.send();

		} catch (EmailException e) {
			return "falha";
		}
		return "sucesso";
	}
}
