package locadora;

import java.util.List;

public class ProdutoNeg {
	
	private ProdutoDAO dao;
	
	public ProdutoNeg() {
		dao = new ProdutoDAO();
	}
	
	public void valida(Produto p) throws Exception {
		StringBuffer msg = new StringBuffer();
		if (p.getNome()==null || p.getNome().length()==0) {
			msg.append("Nome do produto Ž de preenchimento obrigat—rio.");
		}
		if (p.getNome().length()<=4){
			msg.append("O nome do produto deve possuir no m’nimo 5 caracteres.");
		}
		if (p.getTipo()==null || p.getTipo().length()==0) {
			msg.append("Tipo do produto Ž de preenchimento obrigat—rio.");
		}
		if (p.getQuantidade()<0) {
			msg.append("Quantidade do produto n‹o pode ser negativa.");
		}
		if (p.getValor()<0) {
			msg.append("Valor do produto n‹o pode ser negativo.");
		}
		if (msg.length()>0) throw new Exception(msg.toString());
	}
	
	public void salvar(Produto p) throws Exception {
		valida(p);
		dao.salvar(p);
	}
	
	public void alterar(Produto p) throws Exception {
		valida(p);
		dao.alterar(p);
	}	
	
	public List<Produto> getProdutoByNome(String nome) {
		return dao.getProdutoByNome(nome);
	}
	
	public Produto getProdutoById(long id) {
		return dao.getProdutoById(id);
	}
	
	public boolean excluir(long id) {
		return dao.excluir(id);
	}
	
}
