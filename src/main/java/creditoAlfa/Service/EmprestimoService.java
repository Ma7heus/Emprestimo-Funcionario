package creditoAlfa.Service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import creditoAlfa.DAO.ParcelaDAO;
import creditoAlfa.model.Emprestimo;
import creditoAlfa.model.Parcela;

@Stateless
public class EmprestimoService extends GenericService<Emprestimo, Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	

	@Override
	public void cadastrar(Emprestimo entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Emprestimo entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Emprestimo entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Emprestimo> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emprestimo buscaById(Long idEntidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
