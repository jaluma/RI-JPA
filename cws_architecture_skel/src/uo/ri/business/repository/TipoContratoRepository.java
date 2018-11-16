package uo.ri.business.repository;

import uo.ri.model.ContractType;

public interface TipoContratoRepository extends Repository<ContractType> {

	/**
	 * Busca un tipo de contrato a partir de su nombre
	 * @param name del tipo de contrato
	 * @return tipo de contrato
	 */
	ContractType findByName(String name);

}
