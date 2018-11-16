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

	/**
	 * Constructor de la clase añadir 
	 * @param categoria dto de la categoria que quieres añadir
	 */
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

	/**
	 * Comprueba que la categoria introducida sea unica
	 * @param name a comprobar que existe
	 * @throws BusinessException en caso de que ya exista una categoria
	 */
	private void checkUniqueName(String name) throws BusinessException {
		ContractCategory c = repo.findByName(name);
		BusinessCheck.isNull(c, "La categoria con este nombre ya existe.");
	}
	
	/**
	 * Comprueba que los valores a añadir no sea negativos
	 * @param productivityPlus valor a comprobar
	 * @param trieniumSalary valor a comprobar
	 * @throws BusinessException en caso de que alguna de las dos se cumpla
	 */
	private void checkNegativeValues(double productivityPlus,
			double trieniumSalary) throws BusinessException {
		BusinessCheck.isFalse(productivityPlus < 0, "La productividad no puede ser negativa.");
		BusinessCheck.isFalse(trieniumSalary < 0, "El salario del trienio no puede ser negativa.");
	}

}
