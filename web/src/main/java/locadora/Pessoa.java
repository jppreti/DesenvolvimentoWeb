package locadora;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pessoa {

	public static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	protected Long id;
	protected String nome;
	protected Date dataNascimento;
	protected String cpf;

	public Pessoa () {}
	
	public Pessoa (Long id, String nome, Date dataNascimento, String cpf) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void salvar() {
		if (!pessoas.contains(this))
			pessoas.add(this);
	}
	public void excluir() { pessoas.remove(this); }
	public static List<Pessoa> getPessoaPorNome(String nome) {
		List<Pessoa> resultado = new ArrayList<Pessoa>();
		for (Pessoa c: pessoas) 
			if (c.getNome().toUpperCase().indexOf(nome.toUpperCase())>=0)
				resultado.add(c);
		return resultado;
	}
	public static Pessoa getPessoaPorCpf(String cpf) {
		for (Pessoa c: pessoas) 
			if (c.getCpf().equals(cpf))
				return c;
		return null;
	}
	
	public static Pessoa getPessoaPorId(Long id) {
		for (Pessoa c: pessoas) 
			if (c.getId()==id)
				return c;
		return null;
	}
	
	static {
		new Cliente(1L,"Joao",new Date(),"123.456.789-00",123).salvar();
		new Cliente(2L,"Maria",new Date(),"123.456.789-01",321).salvar();
		new Cliente(3L,"Pedro",new Date(),"123.456.789-02",231).salvar();
	}
}
