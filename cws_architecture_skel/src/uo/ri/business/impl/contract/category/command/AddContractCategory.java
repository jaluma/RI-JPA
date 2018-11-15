package uo.ri.business.impl.contract.category.command;

import uo.ri.business.dto.ContractCategoryDto;
import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.EntityAssembler;
import uo.ri.business.repository.CategoriaContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractCategory;

public class AddContractCategory implements Command<Void> {

	private ContractCategoryDto dto;
	private CategoriaContratoRepository repo = Factory.repository.forCategoriaContrato();

	public AddContractCategory(ContractCategoryDto categoria) {
		this.dto = categoria;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		checkUniqueName(dto.name);
		checkNegativeValues(dto.productivityPlus, dto.trieniumSalary);
		ContractCategory contrato = EntityAssembler.toEntity(dto);
		repo.add(contrato);

		return null;
	}

	private void checkUniqueName(String name) throws BusinessException {
		ContractCategory c = repo.findByName(name);
		BusinessCheck.isNull(c, "La categoria con este nombre ya existe.");
	}
	
	private void checkNegativeValues(double productivityPlus,
			double trieniumSalary) throws BusinessException {
		BusinessCheck.isFalse(productivityPlus < 0, "La productividad no puede ser negativa.");
		BusinessCheck.isFalse(trieniumSalary < 0, "El salario del trienio no puede ser negativa.");
	}

}
