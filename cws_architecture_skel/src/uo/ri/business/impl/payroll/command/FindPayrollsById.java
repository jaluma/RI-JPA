package uo.ri.business.impl.payroll.command;

import uo.ri.business.dto.PayrollDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.NominaRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Payroll;

public class FindPayrollsById implements Command<PayrollDto> {

	private Long id;
	private NominaRepository repo = Factory.repository.forNomina();

	public FindPayrollsById(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public PayrollDto execute() throws BusinessException {
		Payroll p = repo.findById(id);
		return p == null ? null : DtoAssembler.toDto(p);
	}

}
