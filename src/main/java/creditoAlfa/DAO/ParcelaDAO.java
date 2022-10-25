package creditoAlfa.DAO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import creditoAlfa.model.Emprestimo;
import creditoAlfa.model.Parcela;

@Stateless
public class ParcelaDAO extends GenericDAO<Parcela, Long>  implements Serializable  {

	public ParcelaDAO() {
		super(Parcela.class);
	}

	public List<Parcela> buscarParcelasPorPeriodo(Date dataInicial, Date dataFinal) {
		List<Parcela> listaParcelas = entityManager.createQuery("SELECT parcela FROM Parcela parcela where "
				+ " dataVencimento >= :dataInicial and dataVencimento <= :dataFinal ";);
		return null;
	}

}
//return entityManager.createQuery(" select entidade from " + clazz.getSimpleName() + " entidade ",
//clazz).getResultList();