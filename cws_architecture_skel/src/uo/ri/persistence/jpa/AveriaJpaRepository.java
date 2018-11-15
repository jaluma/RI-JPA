package uo.ri.persistence.jpa;

import java.util.List;

import uo.ri.business.repository.AveriaRepository;
import uo.ri.model.Averia;
import uo.ri.persistence.jpa.util.BaseRepository;
import uo.ri.persistence.jpa.util.Jpa;

public class AveriaJpaRepository extends BaseRepository<Averia> implements AveriaRepository {

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.AveriaRepository#findByIds(java.util.List)
	 */
	@Override
	public List<Averia> findByIds(List<Long> idsAveria) {
		return Jpa.getManager().createNamedQuery("Averia.findByIds", Averia.class).setParameter(1, idsAveria)
				.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.AveriaRepository#findNoFacturadasByDni(java.lang.String)
	 */
	@Override
	public List<Averia> findNoFacturadasByDni(String dni) {
		return Jpa.getManager().createNamedQuery("Averia.findNoFacturadasByDni", Averia.class).setParameter(1, dni)
				.getResultList();
	}

}
