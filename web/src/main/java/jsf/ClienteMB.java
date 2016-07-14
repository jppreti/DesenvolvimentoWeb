package jsf;

import java.util.Date;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ManagedBean
@SessionScoped
public class ClienteMB {

	private Cliente cliente = new Cliente();
	private String confirmarSenha;
	private boolean esqueceuSenha = false;
	private int codigoSeguranca;

	public boolean isEsqueceuSenha() {
		return esqueceuSenha;
	}

	public void setEsqueceuSenha(boolean esqueceuSenha) {
		this.esqueceuSenha = esqueceuSenha;
	}

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
	
	public void redefinirSenha() {
		setEsqueceuSenha(true);
	}
	
	public String resetarSenha() {
		int posCliente = cliente.clientes.indexOf(cliente);
		Cliente c = null; 
		if (posCliente>=0)
			c = cliente.clientes.get(posCliente);
		
		if (c!=null && c.getTelefone().equalsIgnoreCase(cliente.getTelefone())) {
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
				Random r = new Random();
				r.setSeed(new Date().getTime());
				codigoSeguranca = r.nextInt(10000);
				email.setMsg("Codigo: " + codigoSeguranca);
				email.send();
				setEsqueceuSenha(false);
				return "sucesso";
			} catch (EmailException e) {
				return "falhaServidor";
			}
		}
		System.out.println("Não achou o cliente.");
		FacesContext.getCurrentInstance().addMessage("frmCliente", new FacesMessage("Dados não conferem!"));
		return "falha";
	}
}
