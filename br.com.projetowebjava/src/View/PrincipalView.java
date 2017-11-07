package View;

import java.util.Scanner;

import Controler.FunControler;
import Controler.FuncionarioJpaDao;
import Model.Funcionario;
import javassist.bytecode.LineNumberAttribute.Pc;

public class PrincipalView {

	// Estanciando outra classe //
	// FunControler fc = new FunControler();
	static Funcionario ff = new Funcionario();
	private Scanner sc;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PrincipalView pc = new PrincipalView();
		int op;

		// Usaremos o DO - WHILE para ficar retornando ao menu //
		do {
			System.out.println("*************************");
			System.out.println("*HIBERNATE + JSP + MYSQL*");
			System.out.println("*************************");
			System.out.println("1 - CADASTRO");
			System.out.println("2 - CONSULTA");
			System.out.println("3 - ALTERAÇÃO");
			System.out.println("4 - EXCLUSÃO");
			System.out.println("Digite uma das opções:");
			op = sc.nextInt();

			// Menu de metodos //
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
			// Enquanto não for 5 não ira para de retornar //
		} while (op != 5);

	}

	// Metodos //

	// Ira adicionar dados ao banco de dados //
	public void salvar() {
		sc = new Scanner(System.in);
		System.out.println("\n*************************");
		System.out.println("********CADASTRAR********");
		System.out.println("*************************");
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

		while (ff.getNome().isEmpty() || ff.getCpf().isEmpty() || ff.getPass().isEmpty() || ff.getUser().isEmpty()) {

			System.out.println("Todos os campos devem ser preenchidos!");

			if (ff.getNome().isEmpty()) {
				System.out.println("Digite o nome: ");
				ff.setNome(sc.nextLine());
			}
			if (ff.getCpf().isEmpty()) {
				System.out.println("CPF:");
				ff.setCpf(sc.nextLine());
			}

		}

		FuncionarioJpaDao.getInstance().merge(ff);

		System.out.println("\nSalvo com sucesso!\n");

	}

	// Ira deletar os dados do banco de dados //
	public void deletar() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n***********************");
		System.out.println("********REMOVER********");
		System.out.println("***********************");
		System.out.println("Digite ID: ");
		int id = sc.nextInt();

		try {

			ff = FuncionarioJpaDao.getInstance().getById(id);
			System.out.println("\n************************");
			System.out.println("********CONSULTA********");
			System.out.println("************************");
			System.out.println("Nome: " + ff.getNome());
			System.out.println("CPF: " + ff.getCpf());
			System.out.println("Telefone: " + ff.getTel());
			System.out.println("Usuário: " + ff.getUser());
			System.out.println("\n");

			System.out.println("Deseja realmente remover o funcionario " + ff.getNome() + "? 1 - (SIM), 2 - (NÃO)");
			int s = sc.nextInt();
			if (s == 1) {
				FuncionarioJpaDao.getInstance().remover(ff);
			}
			if (s == 2) {
				System.out.println("\nFuncionario não removido!\n");
			}
		} catch (Exception ex) {

			System.out.println("\n************************");
			System.out.println("**********ERRO**********");
			System.out.println("************************");
			System.out.println("\nID não cadastrado!\n");
		}
	}

	public void consultar() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite ID: ");
		int id = sc.nextInt();
		// Realizando a busca via id //
		try {
			ff = FuncionarioJpaDao.getInstance().getById(id);
			System.out.println("\n************************");
			System.out.println("********CONSULTA********");
			System.out.println("************************");
			System.out.println("Nome: " + ff.getNome());
			System.out.println("CPF: " + ff.getCpf());
			System.out.println("Telefone: " + ff.getTel());
			System.out.println("Usuário: " + ff.getUser());
			System.out.println("\n");
		} catch (Exception ex) {

			System.out.println("\n************************");
			System.out.println("**********ERRO**********");
			System.out.println("************************");
			System.out.println("\nID não cadastrado!\n");

		}

	}

}
