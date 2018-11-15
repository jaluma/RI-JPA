package uo.ri.persistence.jpa;

import java.util.List;

import uo.ri.business.repository.ContratoRepository;
import uo.ri.model.Contract;
import uo.ri.persistence.jpa.util.BaseRepository;
import uo.ri.persistence.jpa.util.Jpa;

public class ContratoJpaRepository extends BaseRepository<Contract> implements ContratoRepository {

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.ContratoRepository#findContractsByMechanicId(java.lang.Long)
	 */
	@Override
	public List<Contract> findContractsByMechanicId(Long id) {
		return Jpa.getManager().createNamedQuery("Contrato.findContractsByMechanicId", Contract.class)
				.setParameter(1, id).getResultList();
	}

}
