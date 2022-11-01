package creditoAlfa.DAO;

import javax.ejb.Stateless;

import creditoAlfa.model.Emprestimo;

@Stateless
public class EmprestimoDAO extends GenericDAO<Emprestimo, Long>{

	public EmprestimoDAO() {
		super(Emprestimo.class);
	}

}
