package creditoAlfa.Service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

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
	
	public boolean funcionarioAlreadyExist(Funcionario funcionario) { // verifica se funcionario existe no banco
		List<Funcionario> listaFuncionarios=  funcionarioDAO.buscarTodos();
		for (Funcionario funcionarioList : listaFuncionarios) {
			if (funcionarioList.getCpf().equals(funcionario.getCpf())) {
				System.out.println("funcionario a ser cadastrado " + funcionario.getCpf());
				System.out.println("Funcionario ja cadastrado " + funcionarioList.getCpf());
				System.out.println("O funcionario com Cpf " + funcionario.getCpf() 
				+ " já existe!");
				return true;
			}
		}		
		return false;		
	}

	public Boolean validaNomeFuncionario(String nomeFuncionario) {
		if (nomeFuncionario.matches("[A-Z]*")) {
			return true;
		}
		return false;
	};
	

}
