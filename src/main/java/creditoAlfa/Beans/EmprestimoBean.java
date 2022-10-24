package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import creditoAlfa.Service.EmprestimoService;
import creditoAlfa.Service.FuncionarioService;
import creditoAlfa.Service.ParcelaValuesService;
import creditoAlfa.model.Emprestimo;
import creditoAlfa.model.Funcionario;
import creditoAlfa.model.ParcelasValues;

@Named
@ViewScoped
public class EmprestimoBean implements Serializable {

	private static final long serialVersionUID = 1L;	
	private List<Emprestimo> emprestimos;
	private Long idEmprestimos;
	private Emprestimo emprestimo = new Emprestimo();
	private Long funcionarioId;
	
	@Inject
	EmprestimoService emprestimoService;
	
	@Inject
	FuncionarioService funcionarioService;
	

	
	
	public List<Funcionario> getFuncionarios(){
		System.out.println("Buscando lista de funcionarios");
		return funcionarioService.buscarTodos();
	}
	
	public void gerarParcelas() {
		System.out.println("Gerando parcelas!");
		

	}
	
	
	public String formParcelas() {
		return "parcelas?faces-reirect=true";
	}
	

	
	
	
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	public Long getIdEmprestimos() {
		return idEmprestimos;
	}
	public void setIdEmprestimos(Long idEmprestimos) {
		this.idEmprestimos = idEmprestimos;
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





	public Long getFuncionarioId() {
		return funcionarioId;
	}




	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	

}
