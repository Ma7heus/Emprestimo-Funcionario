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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "parcela_alfa")
public class Parcela {
	
	@Id
	@SequenceGenerator(name="SEQUENCE_PARCELA", sequenceName = "id_parcela",allocationSize = 1)
	@GeneratedValue(generator = "SEQUENCE_PARCELA",strategy = GenerationType.SEQUENCE)
	private Long idParcela;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento = new Date();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmprestimo", foreignKey = @ForeignKey(name="fk_emprestimo"))
	private Emprestimo emprestimo;
	private Long numParcela;
	private BigDecimal valorParcela;
	private BigDecimal valorPago;
	
	
	public Parcela() {
	}
	
	
	
	public Parcela(Date dataVencimento, Emprestimo emprestimo, Long numParcela, BigDecimal valorParcela,
			BigDecimal valorPago) {
		this.dataVencimento = dataVencimento;
		this.emprestimo = emprestimo;
		this.numParcela = numParcela;
		this.valorParcela = valorParcela;
		this.valorPago = valorPago;
	}

	
	public Long getIdParcela() {
		return idParcela;
	}
	public void setIdParcela(Long idParcela) {
		this.idParcela = idParcela;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public BigDecimal getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}
	public BigDecimal getValorPago() {
		return valorPago;
	}
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Long getNumParcela() {
		return numParcela;
	}

	public void setNumParcela(Long numParcela) {
		this.numParcela = numParcela;
	}


	
	
}
