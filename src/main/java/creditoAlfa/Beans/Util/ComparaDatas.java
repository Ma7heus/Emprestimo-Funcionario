package creditoAlfa.Beans.Util;

import java.util.Date;

public class ComparaDatas {

	public boolean verificaInicialMenorQueFinal(Date dataInicial, Date dataFinal) {
		if (dataInicial.compareTo(dataFinal) <=0) {
			return true;
		}
		return false;
	}
	
	public boolean verificaInicialMaiorQueFinal(Date dataInicial, Date dataFinal) {
		if (dataInicial.compareTo(dataFinal) <0) {
			return true;
		}
		return false;
	}
	
	public boolean verificaSeIguais(Date dataInicial, Date dataFinal) {
		if (dataInicial.compareTo(dataFinal) == 0) {
			return true;
		}
		return false;
	}
	
	
}