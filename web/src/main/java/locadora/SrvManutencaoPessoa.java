package locadora;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SrvManutencaoPessoa
 */
@WebServlet("/SrvManutencaoPessoa")
public class SrvManutencaoPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvManutencaoPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnSalvar")!=null)
			btnSalvar(request, response);
	}

	private void btnSalvar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("hdnId");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Pessoa p = null;
		String erro = null;
		String mensagem = null;
		if (id==null || id.length()==0) { //novo
			if (request.getParameter("rdbTipo")!=null &&
			    request.getParameter("rdbTipo").equalsIgnoreCase("CLIENTE")) {
				p = new Cliente();
			} else {
				p = new Funcionario();
			}
		} else { //alterar
			p = Pessoa.getPessoaPorId(Long.parseLong(id));
		}
		p.setNome(request.getParameter("txtNome"));
		p.setCpf(request.getParameter("txtCpf"));
		try {
			p.setDataNascimento(sdf.parse(request.getParameter("txtDataNascimento")));
		} catch (ParseException e) {
			e.printStackTrace();
			erro = "Data Inv‡lida!";
		}
		if (p instanceof Funcionario)
			((Funcionario)p).setSalario(Float.parseFloat(request.getParameter("txtSalario")));
		if (id == null) p.salvar();
		if (erro==null) mensagem = "Pessoa Salva!"; 
		if (erro!=null) request.setAttribute("pessoa", p);//mantem os dados no formulario, mesmo com erro
		request.setAttribute("erro", erro);
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher rd = request.getRequestDispatcher("ManutencaoPessoa.jsp");
		rd.forward(request, response);
	}

}






