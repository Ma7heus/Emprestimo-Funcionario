package creditoAlfa.Service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import creditoAlfa.DAO.FuncionarioDAO;
import creditoAlfa.model.Funcionario;

@Stateless
public class FuncionarioService extends GenericService<Funcionario, Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FuncionarioDAO funcionarioDAO;

	@Override
	public void cadastrar(Funcionario entidade) {
		funcionarioDAO.cadastrar(entidade);
	}

	@Override
	public void deletar(Funcionario entidade) {
		funcionarioDAO.deletar(entidade.getIdFuncionario());
	}

	@Override
	public void atualizar(Funcionario entidade) {
		funcionarioDAO.atualizar(entidade);
	}

	@Override
	public List<Funcionario> buscarTodos() {
		return funcionarioDAO.buscarTodos();
	}

	@Override
	public Funcionario buscaById(Long idEntidade) {
		return funcionarioDAO.buscaById(idEntidade);
	}

	public boolean funcionarioAlreadyExist(Funcionario entidade) {
		try {
			funcionarioDAO.buscaByCPF(entidade.getCpf());
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}

	public Boolean validaNomeFuncionario(String nomeFuncionario) {
		if (nomeFuncionario.matches("[A-Z]*")) {
			return true;
		}
		return false;
	}
}
