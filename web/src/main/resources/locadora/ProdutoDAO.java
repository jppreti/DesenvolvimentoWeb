package locadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

	Connection con = null;
	PreparedStatement pstmtInsert, pstmtSelect, pstmtDelete, pstmtSelectId, pstmtUpdate = null; 
	private final String sqlInsert = "INSERT INTO produto (nome,valor,tipo,quantidade) values (?,?,?,?)";
	private final String sqlSelect = "SELECT * FROM produto WHERE nome LIKE ?";
	private final String sqlSelectId = "SELECT * FROM produto WHERE idproduto = ?";
	private final String sqlDelete = "DELETE FROM produto WHERE idproduto = ?";
	private final String sqlUpdate = "UPDATE produto SET nome=?, valor=?, tipo=?, quantidade=? WHERE idproduto = ?";
	
	public ProdutoDAO() {	
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db","postgres","postgres");
			pstmtInsert = con.prepareStatement(sqlInsert);
			pstmtSelect = con.prepareStatement(sqlSelect);
			pstmtSelectId = con.prepareStatement(sqlSelectId);
			pstmtDelete = con.prepareStatement(sqlDelete);
			pstmtUpdate = con.prepareStatement(sqlUpdate);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean excluir(long id) {
		try {
			pstmtDelete.setLong(1, id);
			pstmtDelete.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public Produto getProdutoById(long id) {
		try {
			pstmtSelectId.setLong(1, id);
			ResultSet rs = pstmtSelectId.executeQuery();
			if (rs.next()) {
				Produto p = new Produto();
				p.setIdproduto(rs.getLong("idproduto"));
				p.setNome(rs.getString("nome"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setValor(rs.getFloat("valor"));
				p.setTipo(rs.getString("tipo"));
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void alterar(Produto p) {
		try {
			pstmtUpdate.setString(1,p.getNome());
			pstmtUpdate.setFloat(2, p.getValor());
			pstmtUpdate.setString(3, p.getTipo());
			pstmtUpdate.setInt(4, p.getQuantidade());
			pstmtUpdate.setLong(5, p.getIdproduto());
			pstmtUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	public List<Produto> getProdutoByNome(String nome) {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		try {
			pstmtSelect.setString(1, "%" + nome + "%");
			ResultSet rs = pstmtSelect.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();
				p.setIdproduto(rs.getLong("idproduto"));
				p.setNome(rs.getString("nome"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setValor(rs.getFloat("valor"));
				p.setTipo(rs.getString("tipo"));
				produtos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	public void salvar(Produto p) {
		try {
			pstmtInsert.setString(1,p.getNome());
			pstmtInsert.setFloat(2, p.getValor());
			pstmtInsert.setString(3, p.getTipo());
			pstmtInsert.setInt(4, p.getQuantidade());
			pstmtInsert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		Produto p = new Produto(null,"Sab‹o",12f,"LIMPEZA",23);
		new ProdutoDAO().salvar(p);
	}
	
	public void finalize() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
