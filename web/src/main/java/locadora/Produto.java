package locadora;

public class Produto {

	private Long idproduto;
	private String nome;
	private float valor;
	private String tipo;
	private int quantidade;
	
	public Produto() {}

	public Produto(Long idproduto, String nome, float valor, String tipo,
			int quantidade) {
		this.idproduto = idproduto;
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
		this.quantidade = quantidade;
	}

	public Long getIdproduto() {
		return idproduto;
	}

	public String getNome() {
		return nome;
	}

	public float getValor() {
		return valor;
	}

	public String getTipo() {
		return tipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
