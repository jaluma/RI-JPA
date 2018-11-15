package uo.ri.business.repository;

import uo.ri.model.ContractCategory;

public interface CategoriaContratoRepository extends Repository<ContractCategory> {

	ContractCategory findByName(String name);

}
