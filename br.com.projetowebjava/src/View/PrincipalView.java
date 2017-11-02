package View;

import java.util.Scanner;

import Controler.FunControler;
import Controler.FuncionarioJpaDao;
import Model.Funcionario;

public class PrincipalView {

	static // Estanciando outra classe //
	FunControler fc = new FunControler();
	static Funcionario ff = new Funcionario();
	private Scanner sc;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PrincipalView pc = new PrincipalView();

		System.out.println("*************************");
		System.out.println("*HIBERNATE + JSP + MYSQL*");
		System.out.println("*************************");
		System.out.println("1 - CADASTRO");
		System.out.println("2 - CONSULTA");
		System.out.println("3 - ALTERAÇÃO");
		System.out.println("4 - EXCLUSÃO");
		System.out.println("Digite uma das opçẽos:");
		int op = sc.nextInt();

		switch (op) {
		case 1:
			pc.salvar();
			break;
		case 2:
			pc.consultar();
			break;
		case 3:
			break;
		case 4:
			pc.deletar();
			break;

		}

	}

	// Ira adicionar dados ao banco de dados //
	public void salvar() {
		sc = new Scanner(System.in);

		System.out.println("Digite o nome: ");
		ff.setNome(sc.nextLine());
		System.out.println("CPF:");
		ff.setCpf(sc.nextLine());
		System.out.println("Digite seu Login:");
		ff.setUser(sc.nextLine());
		System.out.println("Digite sua senha");
		ff.setPass(sc.nextLine());
		System.out.println("Digite seu Telefone:");
		ff.setTel(sc.nextLine());
		FuncionarioJpaDao.getInstance().merge(ff);

		System.out.println("Salvo com sucesso!");

	}

	// Ira deletar os dados do banco de dados //
	public void deletar() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite ID: ");
		int id = sc.nextInt();

		ff = FuncionarioJpaDao.getInstance().getById(id);
		System.out.println("Removido com sucesso!");

	}

	public void consultar() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite ID: ");
		int id = sc.nextInt();
		// Realizando a busca via id //
		ff = FuncionarioJpaDao.getInstance().getById(id);
		System.out.println("CONSULTA");
		System.out.println("Nome: " + ff.getNome());
		System.out.println("CPF: " + ff.getCpf());
		System.out.println("Telefone: " + ff.getTel());
		System.out.println("Usuário: " + ff.getUser());

	}

}
