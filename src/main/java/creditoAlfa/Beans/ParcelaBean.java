package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import creditoAlfa.Service.ParcelaService;
import creditoAlfa.Service.ParcelaValuesService;
import creditoAlfa.model.Funcionario;
import creditoAlfa.model.Parcela;
import creditoAlfa.model.ParcelasValues;

@Named
@ViewScoped
public class ParcelaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	ParcelaService parcelaService;

	private Long IdParcela;
	private List<Parcela> parcelas = new ArrayList<>();
	private Parcela parcela = new Parcela();
	private Date dataInicial;
	private Date dataFinal;

	
	@PostConstruct
	public void init() {
		buscaParcelasPorperiodo();
		buscarTodasParcelas();
	}

	public void buscarTodasParcelas() {
		System.out.println("Buscando todas parcelas");
		this.parcelas = parcelaService.buscarTodos();
	}

	public List<Parcela> buscaParcelasPorperiodo() {
		System.out.println("Buscando parcelas por periodo");
		return parcelaService.buscarParcelasPorPeriodo(this.dataInicial,this.dataFinal);
	}

	public void baixarParcela(Long idParcela) {
			if (idParcela == null) {
			System.out.println("ID PARCELA NULO!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Id da parcela selecionada é nulo!"));
		} else {
			parcelaService.baixarParcela(idParcela);
			this.parcelas = parcelaService.buscarTodos();
			System.out.println("PARCELA BAIXADA");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parcela baixada!"));
		}

	}

	// --------------------------------------

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
	
	
	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}


}
