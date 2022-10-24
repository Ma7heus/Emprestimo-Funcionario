package creditoAlfa.DAO;

import javax.ejb.Stateless;

import creditoAlfa.model.ParcelasValues;

@Stateless
public class ParcelaValuesDAO extends GenericDAO<ParcelasValues, Long> {

	public ParcelaValuesDAO() {
		super(ParcelasValues.class);
	}

}
