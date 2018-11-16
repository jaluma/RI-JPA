package uo.ri.business.repository;

import java.util.List;

import uo.ri.model.Contract;

public interface ContratoRepository extends Repository<Contract> {

	/**
	 * Busca los contratos de un mecanico dado
	 * @param id del mecanico 
	 * @return una lista con todos los contratos del mecanico dado, puede ser de tamaño 0
	 */
	List<Contract> findContractsByMechanicId(Long id);

}
