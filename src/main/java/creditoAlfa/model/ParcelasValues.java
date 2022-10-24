package creditoAlfa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ParcelasValues {
	
	@Id
	@SequenceGenerator(name="SEQUENCE_PARCELA_VALUES", sequenceName = "id_parcelaValue",allocationSize = 1)
	@GeneratedValue(generator = "SEQUENCE_PARCELA_VALUES",strategy = GenerationType.SEQUENCE)
	private Long idParcelaValue;
	private Long quantidadeParcela;
	
	public ParcelasValues() {
	}
	
	
	public ParcelasValues(Long quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public Long getId() {
		return idParcelaValue;
	}

	public void setId(Long id) {
		this.idParcelaValue = id;
	}

	public Long getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(Long quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}
	
	
	
}
