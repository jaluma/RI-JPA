package uo.ri.business.impl.payroll.command;

import java.util.List;

import uo.ri.business.dto.PayrollDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.NominaRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Payroll;

public class FindPayrollsByMechanicId implements Command<List<PayrollDto>> {

	private Long mechanicId;
	private NominaRepository repo = Factory.repository.forNomina();

	public FindPayrollsByMechanicId(Long mechanicId) {
		this.mechanicId = mechanicId;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public List<PayrollDto> execute() throws BusinessException {
		List<Payroll> list = repo.findPayrollsByMechanicId(mechanicId);
		return DtoAssembler.toPayrollDtoList(list);
	}

}
