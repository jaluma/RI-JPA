package uo.ri.business.impl.contract.type.command;

import uo.ri.business.dto.ContractTypeDto;
import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.EntityAssembler;
import uo.ri.business.repository.TipoContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractType;

public class AddContractType implements Command<Void> {

	private ContractTypeDto dto;
	private TipoContratoRepository repo = Factory.repository.forTipoContrato();

	/**
	 * Contructo que permite añadir un tipo de contrato
	 * @param categoria tipo de contrato a añadir
	 */
	public AddContractType(ContractTypeDto categoria) {
		this.dto = categoria;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		checkUniqueName(dto.name);
		checkNegativeValues(dto.compensationDays);
		ContractType tipo = EntityAssembler.toEntity(dto);
		repo.add(tipo);

		return null;
	}

	/**
	 * Comrpeuba que el nombre no exista ya
	 * @param name del tipo a añadir
	 * @throws BusinessException en caso de que se encuentre ya uno
	 */
	private void checkUniqueName(String name) throws BusinessException {
		ContractType t = repo.findByName(name);
		BusinessCheck.isNull(t, "El tipo de contrato con este nombre ya existe.");
	}
	
	/**
	 * Comprueba que la compensacion no sea negativa
	 * @param compensationDays del tipo a añadir
	 * @throws BusinessException en caso de que  compensationDays sea negativa
	 */
	private void checkNegativeValues(double compensationDays) throws BusinessException {
		BusinessCheck.isFalse(compensationDays < 0, "Los días de compensación no pueden ser negativos.");
	}

}
