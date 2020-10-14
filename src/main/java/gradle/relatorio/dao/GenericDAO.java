package gradle.relatorio.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;


import gradle.relatorio.util.HibernateUtil;

public class GenericDAO<Entidade> {	

//Da suporte aos algoritmos de pesquisa.
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
//Metodo generico salvar
	public void salvar(Entidade ent) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(ent);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	// Metodo listar generico
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			CriteriaQuery<Entidade> consulta = sessao.getCriteriaBuilder().createQuery(classe);
			consulta.from(classe);

			List<Entidade> ent = sessao.createQuery(consulta).getResultList();
			return ent;
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}

	}
	// Metodo listar ordenado generico
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(String campoOrdenado) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			@SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(classe);//getCriteriaBuilder().createQuery(classe);
			consulta.addOrder(Order.asc(campoOrdenado));
			//consulta.from(classe);
			
			List<Entidade> ent = consulta.list();//sessao.createQuery(consulta).getResultList();
			return ent;
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}

	}

	/*
	 * // Metodo buscar generico
	 * 
	 * @SuppressWarnings("deprecation") public Entidade buscar(Long codigo) {
	 * Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); try {
	 * 
	 * Criteria consulta = sessao.createCriteria(classe);
	 * consulta.add(Restrictions.idEq(codigo));
	 * 
	 * @SuppressWarnings("unchecked") Entidade lista = (Entidade)
	 * consulta.uniqueResult();
	 * 
	 * return lista;
	 * 
	 * } catch (RuntimeException ex) { throw ex; } finally { sessao.close(); }
	 * 
	 * }
	 */
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		final CriteriaBuilder criteriaBuilder = sessao.getCriteriaBuilder();
		try {

			CriteriaQuery<Entidade> crit = criteriaBuilder.createQuery(classe);
			Root<Entidade> root = crit.from(classe);
			crit.where(criteriaBuilder.equal(root.get("codigo"), codigo)).distinct(true);

			return sessao.createQuery(crit).getSingleResult();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
	}

	// Metodo generico excluir quase como o salvar
	public void excluir(Entidade ent) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(ent);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	// Metodo generico editar quase igual aoexcluir bem como o salvar
	public void editar(Entidade ent) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(ent);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	// Metodo generico merge para facilitar o uso do salvar e editar na tela
	public void merge(Entidade ent) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.merge(ent);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

}
