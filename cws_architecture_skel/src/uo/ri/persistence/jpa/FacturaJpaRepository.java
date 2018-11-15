package uo.ri.persistence.jpa;

import uo.ri.business.repository.FacturaRepository;
import uo.ri.model.Factura;
import uo.ri.persistence.jpa.util.BaseRepository;
import uo.ri.persistence.jpa.util.Jpa;

public class FacturaJpaRepository extends BaseRepository<Factura> implements FacturaRepository {

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.FacturaRepository#findByNumber(java.lang.Long)
	 */
	@Override
	public Factura findByNumber(Long numero) {
		return Jpa.getManager().createNamedQuery("Factura.findByNumber", Factura.class).setParameter(1, numero)
				.getResultList().stream().findFirst().orElse(null);
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.FacturaRepository#getNextInvoiceNumber()
	 */
	@Override
	public Long getNextInvoiceNumber() {
		return Jpa.getManager().createNamedQuery("Factura.getNextInvoiceNumber", Long.class).getResultList().stream()
				.findFirst().orElse((long) 0);
	}

}
