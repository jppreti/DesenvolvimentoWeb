package unidade3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ComboServlet")
public class ComboServlet extends HttpServlet {

	ArrayList<String> opcoes = new ArrayList<String>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("txtOpcao")!=null)
			opcoes.add(request.getParameter("txtOpcao"));
		
		String ops = "";
		
		for (String o : opcoes) {
			ops += "<option>" + o + "</option>";
		}
		
		request.setAttribute("ops",ops);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ComboDinamico2.jsp");
		dispatcher.forward(request, response);
	}

}
