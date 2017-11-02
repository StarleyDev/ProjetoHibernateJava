package Controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import FabricaConexao.HibernateUtil;
import Model.Funcionario;

public class LogControler {

	public boolean authenticateUser(String userId, String pwd) {

		Funcionario fun = getUserById(userId);

		if (fun != null && fun.getUser().equals(userId) && fun.getPass().equals(pwd)) {
			return true;
		} else {

			return false;
		}

	}

	public Funcionario getUserById(String userId) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Funcionario user = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where userId='" + userId + "'");
			user = (Funcionario) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	public List<Funcionario> getListOfUser() {

		List<Funcionario> list = new ArrayList<Funcionario>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Funcionario fun = null;
		Session session = sf.getCurrentSession();
		EntityManager em = null;
		try {

			em.getTransaction().begin();
			list = session.createNativeQuery("from funcionario").list();
			em.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {

			session.close();
		}
		return list;
	}

}
