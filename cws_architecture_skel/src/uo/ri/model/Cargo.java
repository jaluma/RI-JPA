package uo.ri.model;

import java.util.Date;

import alb.util.date.Dates;
import uo.ri.model.types.FacturaStatus;

public class Cargo {
	private Long id;

	private Factura factura;
	private MedioPago medioPago;
	private double importe = 0.0;

	Cargo() {

	}

	public Cargo(Factura factura, MedioPago medioPago, double importe) {
		this.factura = factura;
		checkParameters(medioPago, importe);
		this.medioPago = medioPago;
		this.importe = importe;
		this.medioPago.acumulado += importe;
		Association.Cargar.link(factura, medioPago, this);
	}

	private void checkParameters(MedioPago medioPago, double importe) {
		if (medioPago instanceof TarjetaCredito) {
			checkValidez(((TarjetaCredito) medioPago).validez);
		}
		if (medioPago instanceof Bono) {
			checkImporte(((Bono) medioPago).getDisponible(), importe);
		}
	}

	private void checkImporte(double disponible, double importe) {
		if (importe > disponible) {
			throw new IllegalStateException("El importe del bono es inferior");
		}

	}

	private void checkValidez(Date validez) {
		if (Dates.isBefore(validez, Dates.today())) {
			throw new IllegalStateException("La fecha de validez es incorrecta");
		}

	}

	/**
	 * Anula (retrocede) este cargo de la factura y el medio de pago Solo se puede
	 * hacer si la factura no está abonada Decrementar el acumulado del medio de
	 * pago Desenlazar el cargo de la factura y el medio de pago
	 * 
	 * @throws IllegalStateException
	 *             if the invoice is already settled
	 */
	public void rewind() {
		if (factura.getStatus().equals(FacturaStatus.ABONADA)) {
			throw new IllegalStateException("No se puede retroceder ");
		}

		medioPago.actualizarAcumulado(-importe);
		Association.Cargar.unlink(this);

	}

	void _setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	void _setFactura(Factura factura) {
		this.factura = factura;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public Factura getFactura() {
		return factura;
	}

	public double getImporte() {
		return importe;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result
				+ ((medioPago == null) ? 0 : medioPago.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (medioPago == null) {
			if (other.medioPago != null)
				return false;
		} else if (!medioPago.equals(other.medioPago))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cargo [factura=" + factura + ", medioPago="
				+ medioPago + ", importe=" + importe + "]";
	}
	
	
}
