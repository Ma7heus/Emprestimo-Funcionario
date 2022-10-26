package creditoAlfa.DAO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import creditoAlfa.model.Parcela;

@Stateless
public class ParcelaDAO extends GenericDAO<Parcela, Long>  implements Serializable  {

	public ParcelaDAO() {
		super(Parcela.class);
	}

	public List<Parcela> buscarParcelasPorPeriodo(Date dataInicial, Date dataFinal) {
		String query = "SELECT parcela FROM Parcela parcela where "
				+ " dataVencimento >= :dataInicial and dataVencimento <= :dataFinal ";
		TypedQuery<Parcela> typedQuery = entityManager.createQuery(query, Parcela.class);
		typedQuery.setParameter("dataInicial", dataInicial);
		typedQuery.setParameter("dataFinal", dataFinal);
		return typedQuery.getResultList();
	}
}
