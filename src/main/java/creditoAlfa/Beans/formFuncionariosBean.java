package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolationException;

import creditoAlfa.Service.FuncionarioService;
import creditoAlfa.model.Funcionario;

@Named
@ViewScoped
public class formFuncionariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Funcionario> funcionarios;
	private Long idFuncionario;
	private Funcionario funcionario = new Funcionario();

	@Inject
	FuncionarioService funcionarioService;
	
	public void deletar(Funcionario funcionario) {
		System.out.println("Deletando Funcionario");
		funcionarioService.deletar(funcionario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario excluido com sucesso!"));
	}

	public String atualizar(Funcionario funcionarioAtualizar) {
		System.out.println("Atualizando Funcionario");
		FacesContext.getCurrentInstance().getExternalContext()
						.getFlash().put("funcionario", funcionarioAtualizar);
		
		return "cadastro?faces-redirect=true";
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
