package locadora;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa {
	
	protected int pontosFidelidade;
	
	public Cliente() { super(); }
	
	public Cliente(Long id, String nome, Date dataNascimento, String cpf, int pontosFidelidade) {
		super (id, nome, dataNascimento, cpf);
		this.pontosFidelidade = pontosFidelidade;
	}

	public int getPontosFidelidade() {
		return pontosFidelidade;
	}

	public void setPontosFidelidade(int pontosFidelidade) {
		this.pontosFidelidade = pontosFidelidade;
	}	
}
