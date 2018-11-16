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

	private void checkExistType(ContractType t) throws BusinessException {
		BusinessCheck.isTrue(t != null, "El tipo de contrato no existe");
	}

	private void checkNegativeValues(double ContractType)
			throws BusinessException {
		BusinessCheck.isFalse(ContractType < 0,
				"La compensación por día no puede ser negativa.");
	}

}
