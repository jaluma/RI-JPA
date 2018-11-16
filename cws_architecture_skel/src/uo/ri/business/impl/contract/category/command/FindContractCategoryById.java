package uo.ri.business.impl.contract.category.command;

import uo.ri.business.dto.ContractCategoryDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.CategoriaContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractCategory;

public class FindContractCategoryById implements Command<ContractCategoryDto> {

	private Long id;
	private CategoriaContratoRepository repo = Factory.repository.forCategoriaContrato();

	/**
	 * Contructor que permite encontrar una categoria de contratos por medio de un id
	 * @param id de la categoria de contrato
	 */
	public FindContractCategoryById(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public ContractCategoryDto execute() throws BusinessException {
		ContractCategory c = repo.findById(id);
		return c == null ? null : DtoAssembler.toDto(c);
	}

}
