package uo.ri.persistence.jpa;

import uo.ri.business.repository.TipoContratoRepository;
import uo.ri.model.ContractType;
import uo.ri.persistence.jpa.util.BaseRepository;
import uo.ri.persistence.jpa.util.Jpa;

public class TipoContratoJpaRepository extends BaseRepository<ContractType>
		implements TipoContratoRepository {

	@Override
	public ContractType findByName(String name) {
		return Jpa.getManager()
				.createNamedQuery("TipoContratos.findByName",
						ContractType.class)
				.setParameter(1, name).getResultList().stream().findFirst()
				.orElse(null);
	}

}
