package uo.ri.business.repository;

import java.util.Date;
import java.util.List;

import uo.ri.model.Mecanico;

public interface MecanicoRepository extends Repository<Mecanico> {

	/**
	 * @param dni
	 * @return the mechanic identified by the dni or null if none
	 */
	Mecanico findByDni(String dni);

	List<Mecanico> findActive();

	double getNumberInterventionsFromTo(Mecanico m, Date startMonth, Date finishMonth);

	List<Mecanico> findActiveAndExtintedThisMonth(Date startMonth, Date finishMonth);

}
