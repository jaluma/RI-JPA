package uo.ri.business.impl.payroll;

import java.util.List;

import uo.ri.business.PayrollService;
import uo.ri.business.dto.PayrollDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.CommandExecutor;
import uo.ri.business.impl.payroll.command.DeleteLastGeneratedPayrolls;
import uo.ri.business.impl.payroll.command.DeleteLastPayrollForMechanicId;
import uo.ri.business.impl.payroll.command.FindAllPayrolls;
import uo.ri.business.impl.payroll.command.FindPayrollsById;
import uo.ri.business.impl.payroll.command.FindPayrollsByMechanicId;
import uo.ri.business.impl.payroll.command.GeneratePayrolls;
import uo.ri.conf.Factory;

public class PayrollServiceImpl implements PayrollService {

	private CommandExecutor executor = Factory.executor.forExecutor();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.PayrollService#findAllPayrolls()
	 */
	@Override
	public List<PayrollDto> findAllPayrolls() throws BusinessException {
		return executor.execute(new FindAllPayrolls());
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.PayrollService#findPayrollsByMechanicId(java.lang.Long)
	 */
	@Override
	public List<PayrollDto> findPayrollsByMechanicId(Long id) throws BusinessException {
		return executor.execute(new FindPayrollsByMechanicId(id));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.PayrollService#findPayrollById(java.lang.Long)
	 */
	@Override
	public PayrollDto findPayrollById(Long id) throws BusinessException {
		return executor.execute(new FindPayrollsById(id));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.PayrollService#deleteLastPayrollForMechanicId(java.lang.Long)
	 */
	@Override
	public void deleteLastPayrollForMechanicId(Long id) throws BusinessException {
		executor.execute(new DeleteLastPayrollForMechanicId(id));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.PayrollService#deleteLastGenetaredPayrolls()
	 */
	@Override
	public int deleteLastGenetaredPayrolls() throws BusinessException {
		return executor.execute(new DeleteLastGeneratedPayrolls());
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.PayrollService#generatePayrolls()
	 */
	@Override
	public int generatePayrolls() throws BusinessException {
		return executor.execute(new GeneratePayrolls());
	}

}
