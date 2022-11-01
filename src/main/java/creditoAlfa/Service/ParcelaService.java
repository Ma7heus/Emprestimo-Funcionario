package creditoAlfa.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import creditoAlfa.Beans.Util.CalculaMeses;
import creditoAlfa.Beans.Util.ComparaDatas;
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
	
	@Inject
	ComparaDatas comparaDatas;

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
		return parcelaDAO.buscaById(idEntidade);
	}

	public List<Parcela> CalculaeCadatraParcelas(Emprestimo emprestimo) {
		BigDecimal taxaJuros = new BigDecimal("0.2");
		BigDecimal quantidadeParcelas = BigDecimal.valueOf(emprestimo.getTotalParcelas()); //converte Long para BigDecimal
		BigDecimal totalJuros = emprestimo.getValorEmprestimo().multiply(taxaJuros);
		BigDecimal valorPorParcela = (totalJuros.add(emprestimo.getValorEmprestimo())).divide(quantidadeParcelas);
		Date datavencimento = emprestimo.getDataPrimeiraParcela();
		List<Parcela> parcelasGeradas = new ArrayList<>();
		
		for (Long i = 1L; i<=emprestimo.getTotalParcelas() ; i++) {
			Parcela parcela =  new Parcela();		
			if (i == 1L ) {
				parcela.setDataVencimento(datavencimento);			
				parcela.setEmprestimo(emprestimo);
				parcela.setNumParcela(i);
				parcela.setValorParcela(valorPorParcela);
				parcela.setValorPago(BigDecimal.ZERO);
				parcela.setIdFuncionario(emprestimo.getFuncionario().getIdFuncionario());
				parcelasGeradas.add(parcela);
				parcelaDAO.cadastrar(parcela);	
			}else {
				datavencimento = calculaMeses.setMont(datavencimento);	
				parcela.setDataVencimento(datavencimento);			
				parcela.setEmprestimo(emprestimo);
				parcela.setNumParcela(i);
				parcela.setValorParcela(valorPorParcela);
				parcela.setValorPago(BigDecimal.ZERO);
				parcela.setIdFuncionario(emprestimo.getFuncionario().getIdFuncionario());
				parcelasGeradas.add(parcela);
				parcelaDAO.cadastrar(parcela);	
			}
		}
		return parcelasGeradas;
	}

	public void baixarParcela(Long idParcela) {
		Parcela parcela = parcelaDAO.buscaById(idParcela);
		BigDecimal valorParcela =  parcela.getValorParcela();
		parcela.setValorPago(valorParcela);
		parcelaDAO.atualizar(parcela);
	}

	public List<Parcela> buscarParcelasPorPeriodo(Date dataInicial, Date dataFinal) {
		if (comparaDatas.verificaInicialMenorQueFinal(dataInicial, dataFinal)) {
			List<Parcela> listaParcelas = parcelaDAO.buscarParcelasPorPeriodo(dataInicial, dataFinal);
			return listaParcelas;
		}		
		return null;
	}

	public List<Parcela> buscarParcelasPorUsuario(Long idFuncionario) {		
		return parcelaDAO.buscarParcelasPorUsuario(idFuncionario);
	}

	public List<Parcela> buscarParcelasVencidas() {
		return parcelaDAO.buscarParcelasVencidas();
	}
}
