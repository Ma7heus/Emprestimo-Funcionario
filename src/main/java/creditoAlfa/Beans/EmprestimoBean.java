package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import creditoAlfa.Beans.Util.RedirecionaPagina;
import creditoAlfa.Service.EmprestimoService;
import creditoAlfa.Service.FuncionarioService;
import creditoAlfa.Service.ParcelaService;
import creditoAlfa.Service.ParcelaValuesService;
import creditoAlfa.model.Emprestimo;
import creditoAlfa.model.Funcionario;
import creditoAlfa.model.Parcela;
import creditoAlfa.model.ParcelasValues;

@Named
@ViewScoped
public class EmprestimoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<ParcelasValues> parcelasValues = new ArrayList<>(); 	
	
	private List<Funcionario> funcionarios =  new ArrayList<>();
	
	private List<Parcela> parcelas = new ArrayList<>();
	
	private Emprestimo emprestimo = new Emprestimo();	
	
	private Long idFuncionario;	
	
	private Long idParcelaValue;
	
	private RedirecionaPagina redirecionaPagina =  new RedirecionaPagina();
	
	@Inject
	EmprestimoService emprestimoService;
	
	@Inject
	FuncionarioService funcionarioService;
	
	@Inject
	ParcelaValuesService parcelaValuesService;
	
	@Inject
	ParcelaService parcelaService;

	
	@PostConstruct
	public void init() {
		buscarParcelasValues();
		buscarFuncionarios();
	}	
	
	public void buscarParcelasValues(){
		System.out.println("Buscando lista valores para seleçao das parcelas");
		this.parcelasValues = parcelaValuesService.buscarTodos();
	}
	
	public void buscarFuncionarios(){
		System.out.println("Buscando lista de funcionarios");
		this.funcionarios = funcionarioService.buscarTodos();
	}
	
	public void gerarParcelas() {
		if (emprestimoService.verificaEmprestimosExistentesParaFuncionario(this.idFuncionario)) {
			if (emprestimoService.dataMaiorQueHoje(this.emprestimo)) {
				this.parcelas = emprestimoService.gerarParcelas(this.emprestimo,idFuncionario,idParcelaValue); // gera parecelas e retorna lista para o front
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Emprestimo realizado com sucesso!",null));	
				System.out.println("Emprestimo realizado!");
				this.emprestimo = new Emprestimo();
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"A data da primeira parcela precisa ser maior que a data atual!",null));	
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ja existem emprestimos vigentes para esse funcionario!",null));
		}
	}
	
	public String formParcelas() {
		return redirecionaPagina.redirect("parcelas");
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Long getIdParcelaValue() {
		return idParcelaValue;
	}

	public void setIdParcelaValue(Long idParcelaValue) {
		this.idParcelaValue = idParcelaValue;
	}


	public void setParcelasValues(List<ParcelasValues> parcelasValues) {
		this.parcelasValues = parcelasValues;
	}

	public List<ParcelasValues> getParcelasValues() {
		return parcelasValues;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
}
