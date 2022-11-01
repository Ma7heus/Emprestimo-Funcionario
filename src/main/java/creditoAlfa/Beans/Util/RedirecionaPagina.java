package creditoAlfa.Beans.Util;

public class RedirecionaPagina {

	public String redirect(String nomePagina) {
		return nomePagina + "?faces-redirect=true";
	}
}
