package Controler;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.query.NativeQuery;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import FabricaConexao.HibernateUtil;
import Model.Funcionario;

public class FunControler {

	// Entidade de gerenciamento //

	// Abrindo sessão de conexão //
	EntityManagerFactory emf;
	// Manipular operações //
	EntityManager em;

	public FunControler() {

		// Abrir uma conexão com banco de dados //

		emf = Persistence.createEntityManagerFactory("off");
		em = emf.createEntityManager();
	}

	// Metodo de salvar //
	public void cadastrar(Funcionario _Funcionario) {

		// Iniciando transação com banco //
		try {

			em.getTransaction().begin();
			// Salvando objeto //
			em.merge(_Funcionario);
			// Comitando para banco //
			em.getTransaction().commit();
			// Encerrando //
			emf.close();

			System.out.println("Funcionario cadastrado com sucesso!");
		}

		catch (Exception ex) {
			System.out.println("Erro ao realizar o cadastro!" + ex);
		}

	}

	// Metodo de excluir //
	public void excluir(Funcionario _Funcionario) {

		try {
			// Iniciando transação com banco //
			em.getTransaction().begin();
			// Removendo objeto //
			Query q = em
					.createNativeQuery("DELETE funcionario FROM funcionario WHERE pass = " + _Funcionario.getPass());
			q.executeUpdate();
			// Comitando para banco //
			em.getTransaction().commit();
			// Encerrando //
			emf.close();

			System.out.println("Funcionario removido com sucesso!");
		}

		catch (Exception ex) {
			System.out.println("Erro ao realizar o remoção!" + ex);
		}

	}

	// Metodo de update //
	public void consultar(Funcionario _Funcionario) {

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			org.hibernate.Transaction tr = session.beginTransaction();

			List<Funcionario> func = session
					.createNativeQuery("SELECT * FORM funcionario WHERE user=" + _Funcionario.getUser())
					.getResultList();

			for (Funcionario Funcionario : func) {
				System.out.println("Nome: " + Funcionario.getNome());
				System.out.println("CPF: " + Funcionario.getCpf());
			}

			tr.commit();
			System.out.println("Data printed");
			sf.close();

			System.out.println("Funcionario Existente!");
		}

		catch (Exception ex) {
			System.out.println("Erro ao realizar o consulta!" + ex);
		}
	}

	// Alterando dados no banco de dados //
	public void alterar(Funcionario _Funcionario) {

		try {
			// Iniciando transação com banco //
			em.getTransaction().begin();
			// Removendo objeto //
			Query q = em
					.createNativeQuery("UPDATE funcionario FROM funcionario WHERE user = " + _Funcionario.getUser());
			q.executeUpdate();
			// Comitando para banco //
			em.getTransaction().commit();
			// Encerrando //
			emf.close();

			System.out.println("Funcionario removido com sucesso!");
		}

		catch (Exception ex) {
			System.out.println("Erro ao realizar o remoção!" + ex);
		}

	}

}
