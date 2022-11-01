package creditoAlfa.Beans;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import creditoAlfa.Beans.Util.RedirecionaPagina;
import creditoAlfa.Service.FuncionarioService;
import creditoAlfa.model.Funcionario;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario = new Funcionario();

	private Long idFuncionario;
	
	private Boolean editaCpf = true;
	
	private RedirecionaPagina redirecionaPagina = new RedirecionaPagina();

	@Inject
	FuncionarioService funcionarioService;

	@PostConstruct
	public void init() {
		Funcionario funcionarioAtualizar = (Funcionario) FacesContext.getCurrentInstance().getExternalContext()
				.getFlash().get("funcionario");
		if (Objects.isNull(funcionarioAtualizar)) {
			this.funcionario = new Funcionario();
		} else {
			this.funcionario = funcionarioAtualizar;
		}
	}

	public String cadastrar() {
		if (this.funcionario.getIdFuncionario() == null) {
			System.out.println("Cadastrando Funcionario " + this.funcionario.getNome());
			if (funcionarioService.funcionarioAlreadyExist(this.funcionario)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"O cpf " + this.funcionario.getCpf() + " já existe no banco!", null));
				return null;
			} else {
				funcionarioService.cadastrar(this.funcionario);
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Novo funcionario cadastrado!", null));
				this.funcionario = new Funcionario();
				return redirecionaPagina.redirect("funcionarios");
			}
		} else {
			atualizaFuncionario();
			return redirecionaPagina.redirect("funcionarios");
		}
	}
	
	private void atualizaFuncionario() {
		System.out.println("Atualizando Funcionario " + this.funcionario.getNome());
		funcionarioService.atualizar(this.funcionario);
		this.funcionario = new Funcionario();
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionario atualizado com sucesso!", null));
	}

	public String tabelaFuncionarios() {
		System.out.println("Chamando tabela de usuarios");
		return redirecionaPagina.redirect("funcionarios");
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

	public Boolean getEditaCpf() {
		if (this.funcionario.getIdFuncionario() == null)
			return this.editaCpf = false;
		return editaCpf;
	}

	public void setEditaCpf(Boolean editaCpf) {
		this.editaCpf = editaCpf;
	}

	public RedirecionaPagina getRedirecionaPagina() {
		return redirecionaPagina;
	}

	public void setRedirecionaPagina(RedirecionaPagina redirecionaPagina) {
		this.redirecionaPagina = redirecionaPagina;
	}
}
