package uo.ri.business.impl.contract.category.command;

import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.repository.CategoriaContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractCategory;

public class DeleteContractCategory implements Command<Void> {

	private Long idCategoria;
	private CategoriaContratoRepository repo = Factory.repository
			.forCategoriaContrato();

	/**
	 * Borra una categoria de contrato
	 * 
	 * @param idCategoria
	 *            a borrar
	 */
	public DeleteContractCategory(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		ContractCategory c = repo.findById(idCategoria);
		checkCanBeDelete(c);
		repo.remove(c);

		return null;
	}

	/**
	 * Comprueba si se puede borrar la categoira
	 * 
	 * @param c
	 *            la categoria
	 * @throws BusinessException
	 *             si hay contratos con ese tipo de categoria o si no existe
	 */
	private void checkCanBeDelete(ContractCategory c) throws BusinessException {
		BusinessCheck.isNotNull(c, "La categoria no existe.");
		BusinessCheck.isTrue(c.getContracts().size() <= 0,
				"No se puede borrar la categoria al tener contratos pertenecientes a esta categoria.");
	}

}
