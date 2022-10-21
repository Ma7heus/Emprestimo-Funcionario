package creditoAlfa.Service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import creditoAlfa.DAO.ParcelaDAO;
import creditoAlfa.model.Parcela;

@Stateless
public class ParcelaService extends GenericService<Parcela, Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	ParcelaDAO parcelaDAO;
	
	@Override
	public void cadastrar(Parcela entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Parcela entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Parcela entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Parcela> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parcela buscaById(Long idEntidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
