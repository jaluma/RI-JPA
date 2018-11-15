package uo.ri.business.impl.payroll.command;

import java.util.List;

import uo.ri.business.dto.PayrollDto;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.NominaRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Payroll;

public class FindAllPayrolls implements Command<List<PayrollDto>> {

	private NominaRepository repo = Factory.repository.forNomina();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public List<PayrollDto> execute() {
		List<Payroll> nominas = repo.findAll();
		return DtoAssembler.toPayrollDtoList(nominas);
	}

}
