package creditoAlfa.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import creditoAlfa.Beans.Util.CalculaMeses;
import creditoAlfa.DAO.EmprestimoDAO;
import creditoAlfa.DAO.ParcelaDAO;
import creditoAlfa.model.Emprestimo;
import creditoAlfa.model.Funcionario;
import creditoAlfa.model.Parcela;
import creditoAlfa.model.ParcelasValues;

@Stateless
public class EmprestimoService extends GenericService<Emprestimo, Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EmprestimoDAO emprestimoDAO;

	@Inject
	ParcelaDAO parcelaDAO;

	@Inject
	CalculaMeses calculaMeses;

	@Inject
	FuncionarioService funcionarioService;

	@Inject
	ParcelaValuesService parcelaValuesService;

	@Inject
	ParcelaService parcelaService;

	@Override
	public void cadastrar(Emprestimo entidade) {
		emprestimoDAO.cadastrar(entidade);
	}

	public List<Parcela> gerarParcelas(Emprestimo emprestimo, Long idFuncionario, Long idParcelaValue) {
		List<Parcela> parcelasGeradas = new ArrayList<>(); // lista de parcelas que vai aparecer no front
		if (dataMaiorQueHoje(emprestimo)) {
			Funcionario funcionario = funcionarioService.buscaById(idFuncionario);
			ParcelasValues quantidadeParcelas = parcelaValuesService.buscaById(idParcelaValue);
			emprestimo.setFuncionario(funcionario);
			emprestimo.setTotalParcelas(quantidadeParcelas.getQuantidadeParcela());

			parcelasGeradas = parcelaService.CalculaeCadatraParcelas(emprestimo); // populando lista
			cadastrar(emprestimo); // metodo dessa classe
		} else {
			throw new RuntimeException("Data da primeira parcela precisa ser maior do que a atual!");
		}
		return parcelasGeradas;
	}

	public boolean dataMaiorQueHoje(Emprestimo emprestimo) {
		Date dataAtual = new Date();
		Date dataPrimeiraParcela = emprestimo.getDataPrimeiraParcela();
		if (dataAtual.compareTo(dataPrimeiraParcela) <= 0) {
			return true;
		}
		return false;
	}

	public Boolean verificaEmprestimosExistentesParaFuncionario(Long idFuncionario) {
		System.out.println("Verificando se existem emprestimos sem pagar");
		List<Parcela> listaParcelas = parcelaService.buscarParcelasPorUsuario(idFuncionario);
		BigDecimal totalParcelasDevidas =  BigDecimal.ZERO;
		BigDecimal totalParcelasPagas =  BigDecimal.ZERO;
		for (Parcela parcela : listaParcelas) {
			totalParcelasDevidas = totalParcelasDevidas.add(parcela.getValorParcela());
			totalParcelasPagas = totalParcelasPagas.add(parcela.getValorPago());
		}

		if (totalParcelasDevidas == BigDecimal.ZERO) {
			return true;
		}
		return false;
	}

	@Override
	public void deletar(Emprestimo entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Emprestimo entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Emprestimo> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emprestimo buscaById(Long idEntidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
