package creditoAlfa.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public abstract class GenericDAO<T,ID> {

	@PersistenceContext
	EntityManager entityManager;
	
	public Class<T> clazz;
	
	public GenericDAO(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public void cadastrar(T entidade) {
		entityManager.persist(entidade);
	}
	
	public void deletar(ID idEntidade) {
		T entidade = entityManager.find(clazz, idEntidade);
		entityManager.remove(entidade);
	}
		
	public void atualizar(T entidade) {
		entityManager.merge(entidade);
	}
	
	public List<T> buscarTodos(){
		return entityManager.createQuery(" select entidade from " + clazz.getSimpleName() + " entidade ",
				clazz).getResultList();
	}
	
	public T buscaById(ID idEntidade) {
		return entityManager.find(clazz, idEntidade);
	}
	
}
	