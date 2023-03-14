package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Astronomia;
import util.JPAUtil;

public class AstronomiaDAO {
	public static void salvar(Astronomia astros) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		em.persist(astros);
		em.getTransaction().commit();
		em.close();
	}


	public static void excluir(Astronomia astros) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		astros = em.find(Astronomia.class, astros.getId());
		em.remove(astros);
		em.getTransaction().commit();
		em.close();

	}

	public static List<Astronomia> listar() {
		EntityManager em = JPAUtil.criaEntityManager();
		Query q = em.createQuery("select astros from Astronomia astros");
		List<Astronomia> lista = q.getResultList();
		em.close();
		return lista;
	}
}
