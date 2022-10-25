package creditoAlfa.Service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import creditoAlfa.DAO.ParcelaValuesDAO;
import creditoAlfa.model.ParcelasValues;

@Stateless
public class ParcelaValuesService extends GenericService<ParcelasValues, Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	ParcelaValuesDAO parcelaValuesDAO;
	
	@Override
	public void cadastrar(ParcelasValues entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(ParcelasValues entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(ParcelasValues entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ParcelasValues> buscarTodos() {
		return parcelaValuesDAO.buscarTodos();
	}

	@Override
	public ParcelasValues buscaById(Long idEntidade) {
		return parcelaValuesDAO.buscaById(idEntidade);
	}

}
