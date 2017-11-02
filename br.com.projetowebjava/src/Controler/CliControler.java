package Controler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Cliente;

public class CliControler {

	// Criando conexão //
	EntityManager em;
	EntityManagerFactory emf;

	public CliControler() {

		// Selecionando banco de dados //
		emf = Persistence.createEntityManagerFactory("off");
		em = emf.createEntityManager();

	}

	public void cadastrar(Cliente _Cliente) {

		try {

			// Abrindo conexão com banco de dados //
			em.getTransaction().begin();
			// Incluindo cliente //
			em.merge(_Cliente);
			// Enviando dados //
			em.getTransaction().commit();
			// Fechando conexão //
			emf.close();

			System.out.println("Cliente cadastrado com suecesso!");

		} catch (Exception ex) {

			System.out.println("Erro ao cadastrar cliente!" + ex);

		}

	}

	public void excluir(Cliente _Cliente) {

		try {
			// Abrindo conexão com banco de dados //
			em.getTransaction().begin();
			// Enviando informação //
			Query q = em.createNamedQuery("DELETE from cliente where cpf=" + _Cliente.getCpf());
			// Executando exclusão //
			q.executeUpdate();
			// Fechando conexão //
			em.close();

			System.out.println("Cliente excluido com seucesso!");

		} catch (Exception ex) {

			System.out.println("Erro ao excluir cliente!" + ex);

		}
	}

	public void consultar(Cliente _Cliente) {

	}
}
