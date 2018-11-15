package uo.ri.persistence.jpa;

import java.util.List;

import uo.ri.business.repository.MedioPagoRepository;
import uo.ri.model.MedioPago;
import uo.ri.persistence.jpa.util.BaseRepository;
import uo.ri.persistence.jpa.util.Jpa;

public class MedioPagoJpaRepository extends BaseRepository<MedioPago> implements MedioPagoRepository {

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.MedioPagoRepository#findPaymentMeansByClientId(java.lang.Long)
	 */
	@Override
	public List<MedioPago> findPaymentMeansByClientId(Long id) {
		return Jpa.getManager().createNamedQuery("MedioPago.findByClientId", MedioPago.class).setParameter(1, id)
				.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.MedioPagoRepository#FindPayMethodsforInvoice(java.lang.Long)
	 */
	@Override
	public List<MedioPago> FindPayMethodsforInvoice(Long idInvoice) {
		return Jpa.getManager().createNamedQuery("MedioPago.findByInvoiceId", MedioPago.class)
				.setParameter(1, idInvoice).getResultList();
	}

}
