package uo.ri.business.impl.contract.command;

import uo.ri.business.dto.ContractDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.ContratoRepository;
import uo.ri.conf.Factory;

public class FindContractById implements Command<ContractDto> {

	private Long id;
	private ContratoRepository repoContrato = Factory.repository.forContrato();

	public FindContractById(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public ContractDto execute() throws BusinessException {
		return DtoAssembler.toDto(repoContrato.findById(id));
	}

}
