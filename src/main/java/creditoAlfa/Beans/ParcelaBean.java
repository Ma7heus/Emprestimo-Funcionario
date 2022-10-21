package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import creditoAlfa.Service.ParcelaService;
import creditoAlfa.model.Parcela;

@Named
@ViewScoped
public class ParcelaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	ParcelaService parcelaService;
	
	private Long IdParcela;
	private List<Parcela> parcelas;
	private Parcela parcela = new Parcela();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ParcelaService getParcelaService() {
		return parcelaService;
	}
	public void setParcelaService(ParcelaService parcelaService) {
		this.parcelaService = parcelaService;
	}
	public Long getIdParcela() {
		return IdParcela;
	}
	public void setIdParcela(Long idParcela) {
		IdParcela = idParcela;
	}
	public List<Parcela> getParcelas() {
		return parcelas;
	}
	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
	public Parcela getParcela() {
		return parcela;
	}
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
