package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolationException;

import creditoAlfa.Service.FuncionarioService;
import creditoAlfa.model.Funcionario;

@Named
@ViewScoped
public class FuncionarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Funcionario> funcionarios;
	private Long idFuncionario;
	private Funcionario funcionario =  new Funcionario();
	
	@Inject
	FuncionarioService funcionarioService;
	
	public void cadastrar(){
		try {
			System.out.println("Cadastrando Funcionario " + this.funcionario.getNome());
			funcionarioService.cadastrar(this.funcionario);
		} catch (ConstraintViolationException e) {
			new RuntimeException("Esse cpf ja existe");
		}
		
		this.funcionario = new Funcionario();
	}
	
	public void deletar(Funcionario funcionario) {
		System.out.println("Deletando Funcionario");
		
	}
	
	public void atualizar(Funcionario funcionario) {
		System.out.println("Atualizando Funcionario");
		
		
		this.funcionario = funcionario;
	}
	

	public String formCadastrar() {
		System.out.println("Chamando form de cadatrar usuario");
		return "cadastro?faces-redirect=true";
	}
	
	public String tabelaFuncionarios() {
		System.out.println("Chamando tabela de usuarios");
		return "funcionarios?faces-redirect=true";
	}
	

	public List<Funcionario> getFuncionarios() {
		return funcionarioService.buscarTodos();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	

	public Long getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}



	
	
	
	
}
