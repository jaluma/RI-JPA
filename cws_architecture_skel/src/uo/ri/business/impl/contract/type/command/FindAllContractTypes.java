package uo.ri.business.impl.contract.type.command;

import java.util.List;

import uo.ri.business.dto.ContractTypeDto;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.TipoContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractType;

public class FindAllContractTypes implements Command<List<ContractTypeDto>> {

	private TipoContratoRepository repo = Factory.repository.forTipoContrato();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public List<ContractTypeDto> execute() {
		List<ContractType> categorias = repo.findAll();
		return DtoAssembler.toContractTypeDtoList(categorias);
	}

}
