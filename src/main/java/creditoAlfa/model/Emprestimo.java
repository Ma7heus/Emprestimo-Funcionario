package creditoAlfa.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emprestimo_alfa")
public class Emprestimo {
	
	@Id
	@SequenceGenerator(name="SEQUENCE_EMPRESTIMO", sequenceName = "id_emprestimo",allocationSize = 1)
	@GeneratedValue(generator = "SEQUENCE_EMPRESTIMO",strategy = GenerationType.SEQUENCE)
	private Long idEmprestimo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdFuncionario", foreignKey = @ForeignKey(name="fk_funcionario"))
	private Funcionario funcionario;	
	private BigDecimal valorEmprestimo;
	private Long totalParcelas;
	@Temporal(TemporalType.DATE)
	private Date dataOperacao = new Date();
	@Temporal(TemporalType.DATE)
	private Date dataPrimeiraParcela = new Date();
	
	public Emprestimo() {
	}
	
	public Emprestimo(Funcionario funcionario, Parcela parcela, BigDecimal valorEmprestimo, Long totalParcelas,
			Date dataOperacao) {
		this.funcionario = funcionario;
		this.valorEmprestimo = valorEmprestimo;
		this.totalParcelas = totalParcelas;
		this.dataOperacao = dataOperacao;
	}

	
	public Long getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(Long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public BigDecimal getValorEmprestimo() {
		return valorEmprestimo;
	}
	public void setValorEmprestimo(BigDecimal valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}
	public Long getTotalParcelas() {
		return totalParcelas;
	}
	public void setTotalParcelas(Long totalParcelas) {
		this.totalParcelas = totalParcelas;
	}



	public Date getDataPrimeiraParcela() {
		return dataPrimeiraParcela;
	}

	public void setDataPrimeiraParcela(Date dataPrimeiraParcela) {
		this.dataPrimeiraParcela = dataPrimeiraParcela;
	}

	
	
}
