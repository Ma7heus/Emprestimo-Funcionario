package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import creditoAlfa.Beans.Util.ComparaDatas;
import creditoAlfa.Service.ParcelaService;
import creditoAlfa.model.Parcela;

@Named
@ViewScoped
public class ParcelaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	ParcelaService parcelaService;

	@Inject
	ComparaDatas comparaDatas;

	private Long IdParcela;
	private List<Parcela> parcelas = new ArrayList<>();
	private Parcela parcela = new Parcela();
	private Date dataInicial;
	private Date dataFinal;
	private Boolean check;

	@PostConstruct
	public void init() {
		buscarTodasParcelas();
	}
	
	public void buscarTodasParcelas() {
		System.out.println("Buscando todas parcelas");
		this.parcelas = parcelaService.buscarTodos();
	}

	public void checkBoxBuscarParcelasVencidas() {
		System.out.println(this.check);
		String texto = check ? "Buscando parcelas vencidas!" : "Buscando todas parcelas!";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(texto));
		
		if (this.check) {
			this.parcelas = parcelaService.buscarParcelasVencidas();
		}else {
			this.parcelas = parcelaService.buscarTodos();
		}
	}

	public void buscaParcelasPorperiodo() {
		if (verificaDatas()){
			if (this.check) {
				this.check = false;
			}
			System.out.println("Buscando parcelas por periodo");
			this.parcelas= parcelaService.buscarParcelasPorPeriodo(this.dataInicial, this.dataFinal);
		}
		
	}

	private Boolean verificaDatas() {
		if (dataInicial == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Selecione a data de vencimento inicial para consulta!", null));
			return false;
		}
		if (dataFinal == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Selecione a data de vencimento final para consulta!", null));
			return false;
		}
		return true;
	}

	public void baixarParcela(Long idParcela) {
		Parcela parcela = parcelaService.buscaById(idParcela);
		if (Objects.nonNull(parcela)) {
			if (parcela.getValorPago().equals(parcela.getValorParcela())) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Parcela já foi baixada!", null));
			} else {
				parcelaService.baixarParcela(idParcela);
				System.out.println("PARCELA BAIXADA");

				this.parcelas = parcelaService.buscarTodos();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Parcela baixada!", null));
			}
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

	

	public Boolean getCheck() {
		return check;
	}


	public void setCheck(Boolean check) {
		this.check = check;
	}
}
