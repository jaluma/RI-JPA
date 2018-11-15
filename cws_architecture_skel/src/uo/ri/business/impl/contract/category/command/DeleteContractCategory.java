package uo.ri.business.impl.contract.category.command;

import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.repository.CategoriaContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractCategory;

public class DeleteContractCategory implements Command<Void> {

	private Long idCategoria;
	private CategoriaContratoRepository repo = Factory.repository.forCategoriaContrato();

	public DeleteContractCategory(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		ContractCategory c = repo.findById(idCategoria);
		checkCanBeDelete(c);
		repo.remove(c);

		return null;
	}

	private void checkCanBeDelete(ContractCategory c) throws BusinessException {
		BusinessCheck.isNotNull(c, "La categoria no existe.");
		BusinessCheck.isTrue(c.getContracts().size() <= 0,
				"No se puede borrar la categoria al tener contratos pertenecientes a esta categoria.");
	}

}
