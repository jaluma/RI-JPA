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

	/**
	 * Encuentra los mecanicos con contrato activo
	 * @return lista con los mecanicos con contrato activo, podría ser 0
	 */
	List<Mecanico> findActive();

	/**
	 * Devuelve el numero total de intervenciones que ha hecho un mecanico dentro de unas fechas
	 * @param m mecanico
	 * @param startMonth dia de inicio
	 * @param finishMonth dia de fin
	 * @return numero de intervenciones en ese espacio de tiempo, podría ser 0
	 */
	double getNumberInterventionsFromTo(Mecanico m, Date startMonth, Date finishMonth);

	/**
	 * Busca los contratos activos y extintos durante un mes
	 * @param startMonth inicio de mes
	 * @param finishMonth fin de mes
	 * @return lista de los mecanicos activos o extintos, podría ser 0
	 */
	List<Mecanico> findActiveAndExtintedThisMonth(Date startMonth, Date finishMonth);

}
