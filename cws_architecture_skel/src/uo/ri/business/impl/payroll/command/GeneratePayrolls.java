package uo.ri.business.impl.payroll.command;

import java.util.Date;
import java.util.List;

import alb.util.date.Dates;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.repository.MecanicoRepository;
import uo.ri.business.repository.NominaRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Contract;
import uo.ri.model.Mecanico;
import uo.ri.model.Payroll;

public class GeneratePayrolls implements Command<Integer> {

	private NominaRepository repoNomina = Factory.repository.forNomina();
	private MecanicoRepository repoMecanico = Factory.repository.forMechanic();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Integer execute() throws BusinessException {

		Date startMonth = Dates.trunc(Dates.firstDayOfMonth(Dates.subMonths(Dates.today(), 1)));
		Date finishMonth = Dates.trunc(Dates.lastDayOfMonth(Dates.subMonths(Dates.today(), 1)));
		List<Mecanico> listMechanic = repoMecanico.findActiveAndExtintedThisMonth(startMonth, finishMonth);

		int addCount = 0;
		for (Mecanico m : listMechanic) {

			Contract contrato = m.getActiveContract();

			if (contrato == null) {
				contrato = m.getLastContract();
			}

			//Payroll existP = repoNomina.findByContractAndDate(contrato.getId(), finishMonth);

			//if (existP == null) {
				double intervenciones = repoMecanico.getNumberInterventionsFromTo(m, startMonth, finishMonth);
				Payroll payroll = new Payroll(contrato, Dates.today(), intervenciones);
				repoNomina.add(payroll);
				addCount++;
			//}

		}

		return addCount;
	}

}
