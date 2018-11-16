package uo.ri.business.repository;

import uo.ri.model.ContractType;

public interface TipoContratoRepository extends Repository<ContractType> {

	ContractType findByName(String name);

}
