package uo.ri.business.impl.payroll.command;

import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.repository.NominaRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Payroll;

public class DeleteLastPayrollForMechanicId implements Command<Void> {

	private Long idMecanico;
	private NominaRepository repoNomina = Factory.repository.forNomina();

	public DeleteLastPayrollForMechanicId(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {

		Payroll p = repoNomina.findLastPayrollByMechanicId(idMecanico);

		checkCanBeDelete(p);
		repoNomina.remove(p);

		return null;
	}

	private void checkCanBeDelete(Payroll p) throws BusinessException {
		BusinessCheck.isNotNull(p, "El empleado no tiene nominas.");
	}

}
