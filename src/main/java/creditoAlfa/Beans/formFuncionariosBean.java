package creditoAlfa.Beans;

import java.io.Serializable;
import creditoAlfa.Beans.Util.RedirecionaPagina;
import java.util.List;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import creditoAlfa.Service.FuncionarioService;
import creditoAlfa.model.Funcionario;

@Named
@ViewScoped
public class FormFuncionariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Funcionario> funcionarios;
	
	private Long idFuncionario;
	
	private Funcionario funcionario = new Funcionario();
	
	private RedirecionaPagina redirecionaPagina = new RedirecionaPagina();

	@Inject
	FuncionarioService funcionarioService;

	public void deletar(Funcionario funcionario) {
		try {
			System.out.println("Deletando Funcionario " + funcionario.getNome());
			funcionarioService.deletar(funcionario);
			this.funcionarios = funcionarioService.buscarTodos();
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
		return redirecionaPagina.redirect("cadastro");
	}

	public String formCadastrar() {
		System.out.println("Chamando form de cadatrar usuario");
		return redirecionaPagina.redirect("cadastro");
	}

	public String tabelaFuncionarios() {
		System.out.println("Chamando tabela de usuarios");
		return redirecionaPagina.redirect("funcionarios");
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

	public RedirecionaPagina getRedirecionaPagina() {
		return redirecionaPagina;
	}

	public void setRedirecionaPagina(RedirecionaPagina redirecionaPagina) {
		this.redirecionaPagina = redirecionaPagina;
	}
}
