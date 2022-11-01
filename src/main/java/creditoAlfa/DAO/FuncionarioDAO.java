package creditoAlfa.DAO;

import javax.persistence.TypedQuery;

import creditoAlfa.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Funcionario, Long> {

	public FuncionarioDAO() {
		super(Funcionario.class);
	}

	public Funcionario buscaByCPF(String cpfFuncionario) {
		String query =  " SELECT funcionario FROM Funcionario funcionario "
				+ " WHERE cpf = :cpfFuncionario ";
		TypedQuery<Funcionario> typedQuery = entityManager.createQuery(query,Funcionario.class);
		typedQuery.setParameter("cpfFuncionario", cpfFuncionario);
		return typedQuery.getSingleResult();
	}

}
