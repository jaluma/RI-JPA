package uo.ri.business.impl.invoice.command;

import java.util.Map;

import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.repository.CargoRepository;
import uo.ri.business.repository.FacturaRepository;
import uo.ri.business.repository.MedioPagoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Cargo;
import uo.ri.model.Factura;
import uo.ri.model.MedioPago;

public class SettleInvoice implements Command<Void> {

	private Long idInvoiceDto;
	private Map<Long, Double> cargos;
	private FacturaRepository repoFactura = Factory.repository.forFactura();
	private MedioPagoRepository repoMedioPago = Factory.repository.forMedioPago();
	private CargoRepository repoCargo = Factory.repository.forCargo();

	public SettleInvoice(Long idInvoiceDto, Map<Long, Double> cargos) {
		this.idInvoiceDto = idInvoiceDto;
		this.cargos = cargos;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		Factura f = repoFactura.findById(idInvoiceDto);

		BusinessCheck.isNull(f, "La factura no existe");
		BusinessCheck.isTrue(f.isSettled(), "La factura ya ha sido abonada");

		for (Long idMediopago : cargos.keySet()) {
			MedioPago m = repoMedioPago.findById(idMediopago);

			BusinessCheck.isNull(m, "El medio de pago " + idMediopago + " no existe.");

			Cargo c = new Cargo(f, m, cargos.get(idMediopago));
			repoCargo.add(c);
		}

		f.settle();
		return null;
	}
}
