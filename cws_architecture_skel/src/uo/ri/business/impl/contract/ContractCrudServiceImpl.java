package uo.ri.business.impl.contract;

import java.util.Date;
import java.util.List;

import alb.util.exception.NotYetImplementedException;
import uo.ri.business.ContractCrudService;
import uo.ri.business.dto.ContractDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.CommandExecutor;
import uo.ri.business.impl.contract.command.FindContractById;
import uo.ri.business.impl.contract.command.FindContractByMechanicId;
import uo.ri.conf.Factory;

public class ContractCrudServiceImpl implements ContractCrudService {

	private CommandExecutor executor = Factory.executor.forExecutor();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCrudService#addContract(uo.ri.business.dto.ContractDto)
	 */
	@Override
	public void addContract(ContractDto c) throws BusinessException {
		throw new NotYetImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCrudService#updateContract(uo.ri.business.dto.ContractDto)
	 */
	@Override
	public void updateContract(ContractDto dto) throws BusinessException {
		throw new NotYetImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCrudService#deleteContract(java.lang.Long)
	 */
	@Override
	public void deleteContract(Long id) throws BusinessException {
		throw new NotYetImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCrudService#finishContract(java.lang.Long, java.util.Date)
	 */
	@Override
	public void finishContract(Long id, Date endDate) throws BusinessException {
		throw new NotYetImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCrudService#findContractById(java.lang.Long)
	 */
	@Override
	public ContractDto findContractById(Long id) throws BusinessException {
		return executor.execute(new FindContractById(id));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCrudService#findContractsByMechanicId(java.lang.Long)
	 */
	@Override
	public List<ContractDto> findContractsByMechanicId(Long id) throws BusinessException {
		return executor.execute(new FindContractByMechanicId(id));
	}

}
