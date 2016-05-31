package unidade2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/consulta")
public class ServletConsultaBanco extends HttpServlet {

	public ServletConsultaBanco() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest req,
						  HttpServletResponse res)
			throws ServletException, IOException {
		String cpf = req.getParameter("txtCpf");
		//o cpf foi validado
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/postgres",
							"postgres","postgres");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nome, telefone, email"
					+ " FROM pessoa WHERE cpf = '" + cpf + "'");
			rs.next();
			res.getWriter().print("Nome: "+rs.getString("nome") + "<br />"
					+ "e-mail: " + rs.getString("email") + "<br />"
					+ "telefone: " + rs.getString("telefone"));
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


