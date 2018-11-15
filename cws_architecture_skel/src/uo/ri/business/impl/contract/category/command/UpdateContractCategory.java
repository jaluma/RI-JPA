package uo.ri.business.impl.contract.category.command;

import uo.ri.business.dto.ContractCategoryDto;
import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.repository.CategoriaContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractCategory;

public class UpdateContractCategory implements Command<Void> {

	private ContractCategoryDto dto;
	private CategoriaContratoRepository repo = Factory.repository.forCategoriaContrato();

	public UpdateContractCategory(ContractCategoryDto dto) {
		this.dto = dto;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		ContractCategory c = repo.findById(dto.id);

		checkExistCategory(c);
		checkNegativeValues(dto.productivityPlus, dto.trieniumSalary);

		c.setProductivityPlus(dto.productivityPlus);
		c.setTrieniumSalary(dto.trieniumSalary);
		return null;
	}
	
	private void checkExistCategory(ContractCategory c) throws BusinessException {
		BusinessCheck.isTrue(c == null, "La categoria no existe");
	}
	
	private void checkNegativeValues(double productivityPlus,
			double trieniumSalary) throws BusinessException {
		BusinessCheck.isFalse(productivityPlus < 0, "La productividad no puede ser negativa.");
		BusinessCheck.isFalse(trieniumSalary < 0, "El salario del trienio no puede ser negativa.");
	}

}
