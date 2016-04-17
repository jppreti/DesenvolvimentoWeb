package unidade3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/unidade3/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {

    private CalculadoraBean calc = new CalculadoraBean();
    public CalculadoraServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String v1 = request.getParameter("txtValor1");
		String v2 = request.getParameter("txtValor2");
		String op = request.getParameter("slcOpcao");
		v1 = (v1==null)?"0":v1;
		v2 = (v2==null)?"0":v2;
		op = (op==null)?"+":op;
		float resultado = calc.calcular(v1, v2, op);
		request.setAttribute("resultado", resultado);
		request.setAttribute("v1", v1);
		request.setAttribute("v2", v2);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Calculadora2.jsp");
		dispatcher.forward(request, response);
	}

}
