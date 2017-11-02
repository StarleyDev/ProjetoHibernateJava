package Servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Controler.FunControler;
import Controler.LogControler;
import Model.Funcionario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("us");
		String pwd = request.getParameter("pwd");

		LogControler logControler = new LogControler();
		boolean result = logControler.authenticateUser(userId, pwd);
		Funcionario fun = logControler.getUserById(userId);

		if (result == true) {

			request.getSession().setAttribute("user", userId);
			response.sendRedirect("home.jsp");

		} else {

			System.out.println("Usuario ou senha incorretos!");
			// RequestDispatcher rs = request.getRequestDispatcher("index.html");
			// rs.forward(request, response);
		}
	}

}
