package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginMB {

	private String nome;
	private String senha;
	private String msg;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String login() {
		if (nome!=null && nome.equals("admin"))
			if (senha!=null && senha.equals("admin")) {
				msg="";
				return "sucesso";
			}
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
