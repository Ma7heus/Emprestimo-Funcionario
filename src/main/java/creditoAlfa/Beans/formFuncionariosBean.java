package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.RollbackException;
import javax.validation.ConstraintViolationException;

import org.postgresql.util.PSQLException;

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
		try {
			System.out.println("Deletando Funcionario " + funcionario.getNome());
			funcionarioService.deletar(funcionario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO
					,"Funcionario excluido com sucesso!",null));

		} catch (EJBTransactionRolledbackException ex) {
			System.out.println("Não é possivel excluir esse funcionario!, o mesmo é usado por outras tabelas!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN
					,"Não é possivel excluir esse funcionario! O mesmo é usado por outras tabelas!",null));
		}
	}

	public String atualizar(Funcionario funcionarioAtualizar) {
		System.out.println("Atualizando Funcionario");
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("funcionario", funcionarioAtualizar);

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
		if (this.funcionarios == null) {
			this.funcionarios = funcionarioService.buscarTodos();
		}
		return funcionarios;
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
