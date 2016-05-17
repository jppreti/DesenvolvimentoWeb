package unidade2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/unidade2/ServletFormulario")
public class ServletFormulario extends HttpServlet {
       
    public ServletFormulario() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nome = request.getParameter("txtNome");
		PrintWriter out = response.getWriter();
		out.print("Ola " + nome);
	}

}
