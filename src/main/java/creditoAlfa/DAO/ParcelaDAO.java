package creditoAlfa.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;

import creditoAlfa.model.Emprestimo;
import creditoAlfa.model.Parcela;

@Stateless
public class ParcelaDAO extends GenericDAO<Parcela, Long>  implements Serializable  {

	public ParcelaDAO() {
		super(Parcela.class);
	}

}
