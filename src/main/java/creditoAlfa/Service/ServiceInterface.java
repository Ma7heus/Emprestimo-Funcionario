package creditoAlfa.Service;

import java.util.List;

public interface ServiceInterface<T,ID> {
	
	public void cadastrar(T entidade);
	
	public void deletar(T entidade);
	
	public void atualizar(T entidade);
	
	public List<T> buscarTodos();
	
	public T buscaById(ID idEntidade);
	
}
