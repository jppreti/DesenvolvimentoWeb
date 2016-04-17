package unidade2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/unidade2/ServletAdicionaOpcao")
public class ServletAdicionaOpcao extends HttpServlet {
	
	ArrayList<String> opcoes = new ArrayList<String>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("txtOpcao")!=null) {
			opcoes.add(request.getParameter("txtOpcao"));
		}
		
		String resultado = "<html>";
		resultado += "<body>";
		resultado += "	<form action=\"ServletAdicionaOpcao\" method=\"post\">";
		resultado += "		<input type=\"text\" name=\"txtOpcao\" />";
		resultado += "		<input type=\"submit\" name=\"btnAdd\" value=\"Add\" />";
		resultado += "		<select>";
		
		for (String o : opcoes) {
			resultado += "	<option>" + o + "</option>";			
		}
		
		resultado += "		</select>";
		resultado += "	</form>";
		resultado += "</body>";
		resultado += "</html>";
		response.getWriter().print(resultado);

	}

}
