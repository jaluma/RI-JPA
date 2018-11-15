package uo.ri.business.impl.contract.category.command;

import java.util.List;

import uo.ri.business.dto.ContractCategoryDto;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.CategoriaContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractCategory;

public class FindAllContractCategory implements Command<List<ContractCategoryDto>> {

	private CategoriaContratoRepository repo = Factory.repository.forCategoriaContrato();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public List<ContractCategoryDto> execute() {
		List<ContractCategory> categorias = repo.findAll();
		return DtoAssembler.toContractCategoryDtoList(categorias);
	}

}
