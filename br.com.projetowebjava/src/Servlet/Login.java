package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controler.FuncionarioJpaDao;
import Model.Funcionario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	// static Funcionario ff = new Funcionario();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("us");
		String pwd = request.getParameter("pwd");
		// Convertendo a String UserID para inteiro //

		System.out.println("Coletado! " + userId);
		System.out.println("Coletado! " + pwd);
		try {

			// FuncionarioJpaDao.getInstance().getById(userId);

			RequestDispatcher rs = request.getRequestDispatcher("Bem vindo!");
			rs.forward(request, response);

		} catch (Exception ex) {

			System.out.println("Usuario ou senha incorretos! " + ex);
			RequestDispatcher rs = request.getRequestDispatcher("Index.jsp");
			rs.forward(request, response);
		}

	}
}
