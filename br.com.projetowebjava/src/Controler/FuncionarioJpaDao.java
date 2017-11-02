package Controler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Funcionario;

public class FuncionarioJpaDao {

	// Criando uma instancia do Funcionario //
	private static FuncionarioJpaDao instance;
	// Criando a entity //
	protected EntityManager entityManager;

	// Criando a instancia e tetornando //
	public static FuncionarioJpaDao getInstance() {

		if (instance == null) {

			instance = new FuncionarioJpaDao();

		}

		return instance;
	}

	public FuncionarioJpaDao() {

		entityManager = getEntityManeger();

	}

	// Criando a conexão //
	private EntityManager getEntityManeger() {

		// Deve ser definido o nome do persistence que esta no xml //
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("off");
		if (entityManager == null) {

			entityManager = factory.createEntityManager();

		}

		return entityManager;
	}

	// Criando uma id para encontrar no banco de dados //
	public Funcionario getById(final int id) {

		return entityManager.find(Funcionario.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> findAll() {

		return entityManager.createQuery("FROM" + Funcionario.class.getName()).getResultList();

	}

	// Persistindo dados no banco //
	public void presist(Funcionario funcionario) {

		try {

			entityManager.getTransaction().begin();
			entityManager.persist(funcionario);
			entityManager.getTransaction().commit();

			System.out.println("Funcionario cadastrado com sucesso!");

		} catch (Exception ex) {
			// Exibe erro caso o metodo acima nao funcione //
			ex.printStackTrace();
			// Usado para desfazer todas as alterações feitas //
			entityManager.getTransaction().rollback();

		}

	}

	public void merge(Funcionario funcionario) {

		try {

			entityManager.getTransaction().begin();
			entityManager.merge(funcionario);
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			// Exibe erro caso o metodo acima nao funcione //
			ex.printStackTrace();
			// Usado para desfazer todas as alterações feitas //
			entityManager.getTransaction().rollback();

		}

	}

	public void remover(Funcionario funcionario) {

		try {

			entityManager.getTransaction().begin();
			funcionario = entityManager.find(Funcionario.class, funcionario.getId());
			entityManager.remove(funcionario);
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			// Exibe erro caso o metodo acima nao funcione //
			ex.printStackTrace();
			// Usado para desfazer todas as alterações feitas //
			entityManager.getTransaction().rollback();

		}

	}

	public void removerById(final int id) {

		try {

			Funcionario funcionario = getById(id);
			remover(funcionario);

		} catch (Exception ex) {
			// Exibe erro caso o metodo acima nao funcione //
			ex.printStackTrace();

		}

	}

}
