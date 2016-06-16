package jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginMB {

	private String nome;
	private String senha;
	
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
			if (senha!=null && senha.equals("admin"))
				return "sucesso";
		return "falha";
	}
	
}
