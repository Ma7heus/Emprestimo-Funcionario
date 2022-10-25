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

import creditoAlfa.Service.FuncionarioService;
import creditoAlfa.model.Funcionario;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Funcionario> funcionarios;
	private Long idFuncionario;
	private Funcionario funcionario = new Funcionario();

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

	public void cadastrar() {
		if (this.funcionario.getIdFuncionario() == null) {
			System.out.println("Cadastrando Funcionario " + this.funcionario.getNome());
			if (funcionarioService.funcionarioAlreadyExist(this.funcionario)) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("O cpf " + this.funcionario.getCpf() + " já existe no banco!"));
			} else {
				funcionarioService.cadastrar(this.funcionario);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Novo funcionario cadastrado!"));
				this.funcionario = new Funcionario();
			}

		}else {
			System.out.println("Atualizando Funcionario " + this.funcionario.getNome());
			funcionarioService.atualizar(this.funcionario);
			this.funcionario = new Funcionario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Funcionario atualizado com sucesso!"));
		}

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
