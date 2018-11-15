package uo.ri.persistence.jpa;

import java.util.Date;
import java.util.List;

import uo.ri.business.repository.MecanicoRepository;
import uo.ri.model.Mecanico;
import uo.ri.persistence.jpa.util.BaseRepository;
import uo.ri.persistence.jpa.util.Jpa;

public class MechanicJpaRepository extends BaseRepository<Mecanico> implements MecanicoRepository {

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.MecanicoRepository#findByDni(java.lang.String)
	 */
	@Override
	public Mecanico findByDni(String dni) {
		return Jpa.getManager()
				.createNamedQuery("Mecanico.findByDni", Mecanico.class)
				.setParameter(1, dni)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.MecanicoRepository#findActive()
	 */
	@Override
	public List<Mecanico> findActive() {
		return Jpa.getManager().createNamedQuery("Mecanico.findActiveMechanics", Mecanico.class).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.MecanicoRepository#getNumberInterventionsFromTo(uo.ri.model.Mecanico, java.util.Date, java.util.Date)
	 */
	@Override
	public double getNumberInterventionsFromTo(Mecanico m, Date startMonth, Date finishMonth) {
		return Jpa.getManager()
				.createNamedQuery("Mecanico.getNumberInterventionsFromTo", Long.class)
				.setParameter(1, m.getId())
				.setParameter(2, startMonth)
				.setParameter(3, finishMonth)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(new Long(0));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.MecanicoRepository#findActiveAndExtintedThisMonth(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Mecanico> findActiveAndExtintedThisMonth(Date startMonth, Date finishMonth) {
		return Jpa.getManager()
				.createNamedQuery("Mecanico.findActiveAndExtintedThisMonth", Mecanico.class)
				.setParameter(1, startMonth)
				.setParameter(2, finishMonth)
				.getResultList();
	}

}
