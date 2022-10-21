package creditoAlfa.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;

import creditoAlfa.model.Emprestimo;

@Stateless
public class EmprestimoDAO extends GenericDAO<Emprestimo, Long>  implements Serializable  {

	public EmprestimoDAO() {
		super(Emprestimo.class);
	}

}
