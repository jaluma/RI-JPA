package uo.ri.business.impl.contract.command;

import java.util.List;

import uo.ri.business.dto.ContractDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.ContratoRepository;
import uo.ri.conf.Factory;

public class FindContractByMechanicId implements Command<List<ContractDto>> {

	private Long id;
	private ContratoRepository repoContrato = Factory.repository.forContrato();

	public FindContractByMechanicId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public List<ContractDto> execute() throws BusinessException {
		return DtoAssembler.toContractDtoList(repoContrato.findContractsByMechanicId(id));
	}

}
