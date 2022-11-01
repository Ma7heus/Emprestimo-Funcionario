package creditoAlfa.DAO;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import creditoAlfa.model.Parcela;

@Stateless
public class ParcelaDAO extends GenericDAO<Parcela, Long> {

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

	public List<Parcela> buscarParcelasPorUsuario(Long idFuncionarioParcela) {
		String query = "SELECT parcela FROM Parcela parcela WHERE "
				+ " idFuncionario = :idFuncionarioParcela ";
		TypedQuery<Parcela> typedQuery = entityManager.createQuery(query, Parcela.class);
		typedQuery.setParameter("idFuncionarioParcela", idFuncionarioParcela);
		return typedQuery.getResultList();
	}
	
	public List<Parcela> buscarParcelasVencidas(){
		Date dataAtual = new Date();
		String query = "SELECT parcela FROM Parcela parcela "
				+ " WHERE dataVencimento <= :dataAtual "; // terminar função
		TypedQuery<Parcela> typeQuery = entityManager.createQuery(query, Parcela.class);
		typeQuery.setParameter("dataAtual", dataAtual);
		System.out.println(dataAtual);
		return typeQuery.getResultList();
	}
}
