package uo.ri.business.repository;

import java.util.Date;
import java.util.List;

import uo.ri.model.Payroll;

public interface NominaRepository extends Repository<Payroll> {

	List<Payroll> findPayrollsByMechanicId(Long mechanicId);

	Payroll findByContractAndDate(Long contratoId, Date date);

	List<Payroll> findLastPayrolls();

	Payroll findLastPayrollByMechanicId(Long idMecanico);

}
