package locadora;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SrvManutencaoProduto")
public class SrvManutencaoProduto extends HttpServlet {

	ProdutoNeg negocio = new ProdutoNeg();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("excluir")!=null) {
			excluir(request,response);
		}
		if (request.getParameter("alterar")!=null) {
			alterar(request,response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnSalvar")!=null) {
				btnSalvar(request, response);
		}
		if (request.getParameter("btnPesquisar")!=null) {
			btnPesquisar(request, response);
		}
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		String mensagem = "";
		
		long id = Long.parseLong(request.getParameter("alterar"));

		request.setAttribute("produto", negocio.getProdutoById(id));
		request.setAttribute("erro", erro);
		request.setAttribute("mensagem", mensagem);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("FrmProduto.jsp");
		dispatcher.forward(request, response);				
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		String mensagem = "";

		long id = Long.parseLong(request.getParameter("excluir"));
		
		if (negocio.excluir(id)) {
			mensagem+="Produto exclu’do com sucesso!";
		} else {
			erro+="N‹o foi poss’vel excluir o produto!";
		}
		
		List<Produto> produtos = negocio.getProdutoByNome(request.getParameter("txtNome"));
		System.out.println(request.getParameter("txtNome"));
		request.setAttribute("erro", erro);
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("produtos", produtos);
		request.setAttribute("txtNome", request.getParameter("txtNome"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("FrmPesquisaProduto.jsp");
		dispatcher.forward(request, response);				
	}
	
	private void btnPesquisar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String erro = "";
		String mensagem = "";
		
		List<Produto> produtos = negocio.getProdutoByNome(request.getParameter("txtNome"));
		
		mensagem+=produtos.size() + " produto(s) encontrado(s)!";

		request.setAttribute("produtos", produtos);
		request.setAttribute("erro", erro);
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("txtNome", request.getParameter("txtNome"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("FrmPesquisaProduto.jsp");
		dispatcher.forward(request, response);		
	}

	private void btnSalvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		String mensagem = "";
		
		String id = request.getParameter("txtId");
		String nome = request.getParameter("txtNome");
		String tipo = request.getParameter("slcTipo");
		float valor = Float.parseFloat(request.getParameter("txtValor"));
		int qtde = Integer.parseInt(request.getParameter("txtQtde"));
		
		Produto p = null;
		try {

			if (id==null || id.length()==0) {
				p = new Produto (null, nome, valor, tipo, qtde);
				negocio.salvar(p);
				mensagem += "Produto Salvo com Sucesso!\n";				
			} else {
				p = new Produto (Long.parseLong(id), nome, valor, tipo, qtde);
				negocio.alterar(p);
				mensagem += "Produto Alterado com Sucesso!\n";
			}
		} catch (Exception e) {
			erro+=e.getMessage()+"\n";
		}
		
		if (erro.length()>0 || !(id==null || id.length()==0))
			request.setAttribute("produto", p);
		request.setAttribute("erro", erro);
		request.setAttribute("mensagem", mensagem);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("FrmProduto.jsp");
		dispatcher.forward(request, response);
	}


}
