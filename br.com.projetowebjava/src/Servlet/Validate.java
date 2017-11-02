package Servlet;

public class Validate {

	public static boolean checkUser(String user, String pass) {

		boolean st = false;

		try {

			// Ira realizar a consulta no banco de dados

			System.out.println("Ok!");

		} catch (Exception ex) {

			System.out.println(ex);

		}

		return st;
	}

}
