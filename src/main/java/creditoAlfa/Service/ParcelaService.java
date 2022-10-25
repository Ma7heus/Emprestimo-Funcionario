package creditoAlfa.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import creditoAlfa.Beans.Util.CalculaMeses;
import creditoAlfa.DAO.ParcelaDAO;
import creditoAlfa.model.Emprestimo;
import creditoAlfa.model.Parcela;

@Stateless
public class ParcelaService extends GenericService<Parcela, Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ParcelaDAO parcelaDAO;
	
	@Inject
	CalculaMeses calculaMeses;

	@Override
	public void cadastrar(Parcela entidade) {
	}

	@Override
	public void deletar(Parcela entidade) {
	}

	@Override
	public void atualizar(Parcela entidade) {
	}

	@Override
	public List<Parcela> buscarTodos() {
		return parcelaDAO.buscarTodos();
	}

	@Override
	public Parcela buscaById(Long idEntidade) {
		return null;
	}

	public void CalculaeCadatraParcelas(Emprestimo emprestimo) {
		BigDecimal taxaJuros = new BigDecimal("0.2");
		BigDecimal quantidadeParcelas = BigDecimal.valueOf(emprestimo.getTotalParcelas()); //converte Long para BigDecimal
		BigDecimal totalJuros = emprestimo.getValorEmprestimo().multiply(taxaJuros);
		BigDecimal valorPorParcela = (totalJuros.add(emprestimo.getValorEmprestimo())).divide(quantidadeParcelas);
		
		Date datavencimento = emprestimo.getDataPrimeiraParcela();
		//Parcela(Date dataVencimento, Emprestimo emprestimo, Long numParcela, BigDecimal valorParcela,
		//BigDecimal valorPago)
		
		for (Long i = 1L; i<=emprestimo.getTotalParcelas() ; i++) {
			Parcela parcela =  new Parcela();		
			if (i == 1L ) {
				parcela.setDataVencimento(datavencimento);			
				parcela.setEmprestimo(emprestimo);
				parcela.setNumParcela(i);
				parcela.setValorParcela(valorPorParcela);
				parcela.setValorPago(new BigDecimal(0));
				parcelaDAO.cadastrar(parcela);	
			}else {
				datavencimento = calculaMeses.setMont(datavencimento);	
				parcela.setDataVencimento(emprestimo.getDataPrimeiraParcela());			
				parcela.setEmprestimo(emprestimo);
				parcela.setNumParcela(i);
				parcela.setValorPago(new BigDecimal(0.0));
				parcela.setValorParcela(valorPorParcela);
				parcelaDAO.cadastrar(parcela);	
			}
		}
	}
		
		
	

}
