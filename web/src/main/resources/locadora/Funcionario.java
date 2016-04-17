package locadora;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa {

	protected float salario;
	
	public Funcionario() { super(); }
	
	public Funcionario(Long id, String nome, Date dataNascimento, String cpf, float salario) {
		super (id, nome, dataNascimento, cpf);
		this.salario = salario;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	} 
}
