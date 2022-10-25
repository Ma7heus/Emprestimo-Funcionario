package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import creditoAlfa.Service.EmprestimoService;
import creditoAlfa.Service.FuncionarioService;
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
	private Emprestimo emprestimo = new Emprestimo();	
	private Long idFuncionario;	
	private Long idParcelaValue;
	
	@Inject
	EmprestimoService emprestimoService;
	
	@Inject
	FuncionarioService funcionarioService;
	
	@Inject
	ParcelaValuesService parcelaValuesService;

	
	@PostConstruct
	public void init() {
		buscarParcelasValues();
		buscarFuncionarios();
	}	
	
	public void buscarParcelasValues(){
		System.out.println("Buscando lista valores para seleçao das parcelas");
		this.parcelasValues = parcelaValuesService.buscarTodos();
	}
	
	public String formParcelas() {
		return "parcelas?faces-redirect=true";
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


	public void buscarFuncionarios(){
		System.out.println("Buscando lista de funcionarios");
		this.funcionarios = funcionarioService.buscarTodos();
	}
	
	public void gerarParcelas() {
		System.out.println("Gerando parcelas!");	
		System.out.println(this.idFuncionario);
		System.out.println(this.idParcelaValue);
		System.out.println(this.emprestimo.getDataOperacao());
		System.out.println(this.emprestimo.getDataPrimeiraParcela());
		System.out.println(this.emprestimo.getValorEmprestimo());
		
		//emprestimoService.gerarParcelas(this.emprestimo,idFuncionario,idParcelaValue);
		
		this.emprestimo = new Emprestimo();
	}
}
