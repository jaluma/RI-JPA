package uo.ri.persistence.jpa;

import uo.ri.business.repository.CategoriaContratoRepository;
import uo.ri.model.ContractCategory;
import uo.ri.persistence.jpa.util.BaseRepository;
import uo.ri.persistence.jpa.util.Jpa;

public class CategoriaJpaRepository extends BaseRepository<ContractCategory> implements CategoriaContratoRepository {

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.CategoriaContratoRepository#findByName(java.lang.String)
	 */
	@Override
	public ContractCategory findByName(String name) {
		return Jpa.getManager()
				.createNamedQuery("CategoriaContratos.findByName",
						ContractCategory.class)
				.setParameter(1, name).getResultList().stream().findFirst()
				.orElse(null);
	}

}
