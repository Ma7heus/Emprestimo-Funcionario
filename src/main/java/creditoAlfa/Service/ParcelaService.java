package creditoAlfa.Service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import creditoAlfa.DAO.ParcelaDAO;
import creditoAlfa.model.Emprestimo;
import creditoAlfa.model.Parcela;

@Stateless
public class ParcelaService extends GenericService<Parcela, Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	ParcelaDAO parcelaDAO;
	
	@Override
	public void cadastrar(Parcela entidade) {
	}

	@Override
	public void deletar(Parcela entidade) {
	}

	@Override
	public void atualizar(Parcela entidade) {
	}

	@Override
	public List<Parcela> buscarTodos() {
		return null;
	}

	@Override
	public Parcela buscaById(Long idEntidade) {
		return null;
	}
	public void CalculaeCadatraParcelas(Emprestimo emprestimo) {
		
		
		
		
	}

}
