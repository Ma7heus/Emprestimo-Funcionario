package creditoAlfa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "funcionario_alfa")
public class Funcionario {

	@Id
	@SequenceGenerator(name = "SEQUENSE_FUNCIONARIO", sequenceName = "id_funcionario", allocationSize = 1)
	@GeneratedValue(generator = "SEQUENSE_FUNCIONARIO", strategy = GenerationType.SEQUENCE)
	private Long IdFuncionario;
	private String nome;
	@Column(unique = true)
	private String cpf;
	private String Setor;
	private String cargo;
	private String observacao;
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao = new Date();

	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, String setor, String cargo, Date dataAdmissao) {
		this.nome = nome;
		this.cpf = cpf;
		Setor = setor;
		this.cargo = cargo;
		this.dataAdmissao = dataAdmissao;
	}

	public Funcionario(String nome, String cpf, String setor, String cargo, Date dataAdmissao, String observacao) {
		this.nome = nome;
		this.cpf = cpf;
		Setor = setor;
		this.cargo = cargo;
		this.observacao = observacao;
		this.dataAdmissao = dataAdmissao;
	}

	public Long getIdFuncionario() {
		return IdFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		IdFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSetor() {
		return Setor;
	}

	public void setSetor(String setor) {
		Setor = setor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
