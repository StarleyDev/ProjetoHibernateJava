package Servlet;

/**
* FunServlet - Modelo servlet //
*
* @version v 1.0 Outubro/2017
* @author STARLLEY
*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.spi.RegisterableService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.hql.internal.ast.tree.FunctionNode;

import Controler.FunControler;
import Controler.FuncionarioJpaDao;
import Model.Funcionario;

/**
 * Servlet implementation class FunServlet
 */
@WebServlet("/FunServlet")
public class FunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Funcionario Funcionario = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FunServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();

		try {

			Funcionario fun = new Funcionario();
			fun.setNome(request.getParameter("nome"));
			fun.setTel(request.getParameter("tel"));
			fun.setCpf(request.getParameter("cpf"));
			fun.setUser(request.getParameter("user"));
			fun.setPass(request.getParameter("pass"));

			FuncionarioJpaDao.getInstance().merge(fun);

			out.println("Cadastrado com sucesso!");

		} catch (Exception ex) {

			out.println("Erro: " + ex);

		}

		RequestDispatcher rd = request.getRequestDispatcher("CADASTRADO COM SUECESSO!");
		rd.forward(request, response);

	}

	private Model.Funcionario Funcionario(String nome, String tel, String cpf, String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

}
