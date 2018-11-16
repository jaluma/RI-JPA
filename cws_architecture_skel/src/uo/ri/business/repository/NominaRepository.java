package uo.ri.business.repository;

import java.util.Date;
import java.util.List;

import uo.ri.model.Payroll;

public interface NominaRepository extends Repository<Payroll> {

	/**
	 * Busca las nominas de un mecanico nada
	 * @param mechanicId del mecanico
	 * @return lista de las nominas de un mecanico, podría ser 0
	 */
	List<Payroll> findPayrollsByMechanicId(Long mechanicId);

	/**
	 * Busca las nominas de un contrato en una fecha dada
	 * @param contratoId del contrato
	 * @param date fecha de la nomian
	 * @return la nomina encontrada o null
	 */
	Payroll findByContractAndDate(Long contratoId, Date date);

	/**
	 * Busca las ultimas nominas generadas
	 * @return lista de las ultimas nominas generadas, podrían ser 0
	 */
	List<Payroll> findLastPayrolls();

	/**
	 * Busca la ultima nomina de un mecanico dada
	 * @param idMecanico del mecanico
	 * @return la nomina encontrada o null
	 */
	Payroll findLastPayrollByMechanicId(Long idMecanico);

}
