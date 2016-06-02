package unidade2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletConsultaBanco extends HttpServlet {

	public ServletConsultaBanco() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
						  HttpServletResponse res)
			throws ServletException, IOException {
		String cpf = req.getParameter("txtCpf");
		//o cpf foi validado
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/postgres",
							"joaopaulodelgadopreti","postgres");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nome, telefone, email"
					+ " FROM pessoa WHERE cpf = '" + cpf + "'");
			rs.next();
			res.getWriter().print("<html><head></head><body>");
			res.getWriter().print("Nome: "+rs.getString("nome") + "<br />"
					+ "e-mail: " + rs.getString("email") + "<br />"
					+ "telefone: " + rs.getString("telefone"));
			res.getWriter().print("</body></html>");
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			res.getWriter().print(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			res.getWriter().print(e.getMessage());
		}
	}
}