package uo.ri.business.repository;

import java.util.List;

import uo.ri.model.Contract;

public interface ContratoRepository extends Repository<Contract> {

	List<Contract> findContractsByMechanicId(Long id);

}
