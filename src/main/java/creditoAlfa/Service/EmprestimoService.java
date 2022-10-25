package creditoAlfa.Service;

import java.io.Serializable;
import java.math.BigDecimal;
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

	public void gerarParcelas(Emprestimo emprestimo, Long idFuncionario, Long idParcelaValue) {
		Funcionario funcionario =  funcionarioService.buscaById(idFuncionario);
		ParcelasValues quantidadeParcelas = parcelaValuesService.buscaById(idParcelaValue);
		emprestimo.setFuncionario(funcionario);
		emprestimo.setTotalParcelas(quantidadeParcelas.getQuantidadeParcela());
		
		parcelaService.CalculaeCadatraParcelas(emprestimo);
		cadastrar(emprestimo); // metodo dessa classe
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
