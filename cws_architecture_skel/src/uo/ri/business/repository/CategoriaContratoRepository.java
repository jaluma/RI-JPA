package uo.ri.business.repository;

import uo.ri.model.ContractCategory;

public interface CategoriaContratoRepository extends Repository<ContractCategory> {

	/**
	 * Encuentra una categoria de contrato buscando a partir de su nombre
	 * @param name a buscar
	 * @return la categoria de contrato encontrado o null
	 */
	ContractCategory findByName(String name);

}
