package locadora;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SrvPesquisaPessoa")
public class SrvPesquisaPessoa extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnPesquisar")!=null) {
			btnPesquisar(request, response);
		}
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao!=null && acao.equalsIgnoreCase("EXCLUIR")) {
			excluir(request, response);
		}
		if (acao!=null && acao.equalsIgnoreCase("ALTERAR")) {
			alterar(request, response);
		}
	}

	private void alterar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		Pessoa pessoa = Pessoa.getPessoaPorCpf(cpf);
		request.setAttribute("pessoa", pessoa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManutencaoPessoa.jsp");
		dispatcher.forward(request, response);	
	}

	private void excluir(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		Pessoa.getPessoaPorCpf(cpf).excluir();
		RequestDispatcher dispatcher = request.getRequestDispatcher("PesquisaPessoa.jsp");
		dispatcher.forward(request, response);
;	}

	private void btnPesquisar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String palavraChave = request.getParameter("txtPalavraChave");
		String opcao = request.getParameter("slcOpcao");
		List<Pessoa> pessoas = null;
		if (opcao.equalsIgnoreCase("NOME")) {
			pessoas = Pessoa.getPessoaPorNome(palavraChave);
		}
		
		if (opcao.equalsIgnoreCase("CPF")) {
			pessoas = new ArrayList<Pessoa>();
			Pessoa p = Pessoa.getPessoaPorCpf(palavraChave);
			pessoas.add(p);
		}
		request.setAttribute("resultado", pessoas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("PesquisaPessoa.jsp");
		dispatcher.forward(request, response);
	}
	
}
