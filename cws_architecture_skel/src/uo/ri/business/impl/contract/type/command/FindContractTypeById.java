package uo.ri.business.impl.contract.type.command;

import uo.ri.business.dto.ContractTypeDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.TipoContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractType;

public class FindContractTypeById implements Command<ContractTypeDto> {

	private Long id;
	private TipoContratoRepository repo = Factory.repository.forTipoContrato();

	public FindContractTypeById(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public ContractTypeDto execute() throws BusinessException {
		ContractType t = repo.findById(id);
		return t == null ? null : DtoAssembler.toDto(t);
	}

}
