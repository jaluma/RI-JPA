package uo.ri.business.impl.contract.category;

import java.util.List;

import uo.ri.business.ContractCategoryCrudService;
import uo.ri.business.dto.ContractCategoryDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.CommandExecutor;
import uo.ri.business.impl.contract.category.command.AddContractCategory;
import uo.ri.business.impl.contract.category.command.DeleteContractCategory;
import uo.ri.business.impl.contract.category.command.FindAllContractCategory;
import uo.ri.business.impl.contract.category.command.FindContractCategoryById;
import uo.ri.business.impl.contract.category.command.UpdateContractCategory;
import uo.ri.conf.Factory;

public class ContractCategoryCrudServiceImpl implements ContractCategoryCrudService {

	private CommandExecutor executor = Factory.executor.forExecutor();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCategoryCrudService#addContractCategory(uo.ri.business.dto.ContractCategoryDto)
	 */
	@Override
	public void addContractCategory(ContractCategoryDto dto) throws BusinessException {
		executor.execute(new AddContractCategory(dto));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCategoryCrudService#deleteContractCategory(java.lang.Long)
	 */
	@Override
	public void deleteContractCategory(Long id) throws BusinessException {
		executor.execute(new DeleteContractCategory(id));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCategoryCrudService#updateContractCategory(uo.ri.business.dto.ContractCategoryDto)
	 */
	@Override
	public void updateContractCategory(ContractCategoryDto dto) throws BusinessException {
		executor.execute(new UpdateContractCategory(dto));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCategoryCrudService#findContractCategoryById(java.lang.Long)
	 */
	@Override
	public ContractCategoryDto findContractCategoryById(Long id) throws BusinessException {
		return executor.execute(new FindContractCategoryById(id));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.ContractCategoryCrudService#findAllContractCategories()
	 */
	@Override
	public List<ContractCategoryDto> findAllContractCategories() throws BusinessException {
		return executor.execute(new FindAllContractCategory());
	}

}
