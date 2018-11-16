package uo.ri.business.impl.contract.type;

import java.util.List;

import uo.ri.business.ContractTypeCrudService;
import uo.ri.business.dto.ContractTypeDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.CommandExecutor;
import uo.ri.business.impl.contract.type.command.AddContractType;
import uo.ri.business.impl.contract.type.command.DeleteContractType;
import uo.ri.business.impl.contract.type.command.FindAllContractTypes;
import uo.ri.business.impl.contract.type.command.FindContractTypeById;
import uo.ri.business.impl.contract.type.command.UpdateContractType;
import uo.ri.conf.Factory;

public class ContractTypeCrudServiceImpl implements ContractTypeCrudService {

	private CommandExecutor executor = Factory.executor.forExecutor();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractTypeCrudService#addContractType(uo.ri.business.dto.ContractTypeDto)
	 */
	@Override
	public void addContractType(ContractTypeDto dto) throws BusinessException {
		executor.execute(new AddContractType(dto));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractTypeCrudService#deleteContractType(java.lang.Long)
	 */
	@Override
	public void deleteContractType(Long id) throws BusinessException {
		executor.execute(new DeleteContractType(id));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractTypeCrudService#updateContractType(uo.ri.business.dto.ContractTypeDto)
	 */
	@Override
	public void updateContractType(ContractTypeDto dto) throws BusinessException {
		executor.execute(new UpdateContractType(dto));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractTypeCrudService#findContractTypeById(java.lang.Long)
	 */
	@Override
	public ContractTypeDto findContractTypeById(Long id) throws BusinessException {
		return executor.execute(new FindContractTypeById(id));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractTypeCrudService#findAllContractCategories()
	 */
	@Override
	public List<ContractTypeDto> findAllContractTypes() throws BusinessException {
		return executor.execute(new FindAllContractTypes());
	}

}
