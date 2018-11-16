package uo.ri.business.impl.contract.type.command;

import uo.ri.business.dto.ContractTypeDto;
import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.repository.TipoContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractType;

public class UpdateContractType implements Command<Void> {

	private ContractTypeDto dto;
	private TipoContratoRepository repo = Factory.repository.forTipoContrato();

	/**
	 * Constructor que permite actualizar el tipo de contrato
	 * @param dto con los datos a actualizar 
	 */
	public UpdateContractType(ContractTypeDto dto) {
		this.dto = dto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		ContractType t = repo.findById(dto.id);

		checkExistType(t);
		checkNegativeValues(dto.compensationDays);

		t.setCompensation(dto.compensationDays);
		return null;
	}

	/**
	 * Comprueba que el tipo exista
	 * @param t con la información del contrato 
	 * @throws BusinessException en caso de que el contrato ya exista
	 */
	private void checkExistType(ContractType t) throws BusinessException {
		BusinessCheck.isTrue(t != null, "El tipo de contrato no existe");
	}

	/**
	 * Compruba que la compensacion no sea negativa
	 * @param compensationDays a actualizar
	 * @throws BusinessException en caso de que la compensacion sea negativa
	 */
	private void checkNegativeValues(double compensationDays)
			throws BusinessException {
		BusinessCheck.isFalse(compensationDays < 0,
				"La compensación por día no puede ser negativa.");
	}

}
