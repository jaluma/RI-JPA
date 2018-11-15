package uo.ri.persistence.jpa;

import java.util.Date;
import java.util.List;

import uo.ri.business.repository.NominaRepository;
import uo.ri.model.Payroll;
import uo.ri.persistence.jpa.util.BaseRepository;
import uo.ri.persistence.jpa.util.Jpa;

public class NominaJpaRepository extends BaseRepository<Payroll> implements NominaRepository {

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.NominaRepository#findPayrollsByMechanicId(java.lang.Long)
	 */
	@Override
	public List<Payroll> findPayrollsByMechanicId(Long mechanicId) {
		return Jpa.getManager().createNamedQuery("Nomina.findPayrollsByMechanicId", Payroll.class)
				.setParameter(1, mechanicId).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.NominaRepository#findByContractAndDate(java.lang.Long, java.util.Date)
	 */
	@Override
	public Payroll findByContractAndDate(Long contratoId, Date date) {
		return Jpa.getManager()
				.createNamedQuery("Nomina.findByContractAndDate", Payroll.class)
				.setParameter(1, contratoId)
				.setParameter(2, date)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.NominaRepository#findLastPayrolls()
	 */
	@Override
	public List<Payroll> findLastPayrolls() {
		return Jpa.getManager()
				.createNamedQuery("Nomina.findLastPayrolls", Payroll.class)
				.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.NominaRepository#findLastPayrollByMechanicId(java.lang.Long)
	 */
	@Override
	public Payroll findLastPayrollByMechanicId(Long idMecanico) {
		return Jpa.getManager()
				.createNamedQuery("Nomina.findLastPayrollByMechanicId", Payroll.class)
				.setParameter(1, idMecanico)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
	}

}
