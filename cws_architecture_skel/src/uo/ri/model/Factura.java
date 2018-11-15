package uo.ri.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import alb.util.date.Dates;
import alb.util.math.Round;
import uo.ri.model.types.FacturaStatus;

public class Factura {
	private Long id;

	private Long numero;

	private Date fecha;
	private double importe;
	private double iva;
	private FacturaStatus status = FacturaStatus.SIN_ABONAR;

	private Set<Averia> averias = new HashSet<>();
	private Set<Cargo> cargos = new HashSet<>();

	Factura() {
	}

	public Factura(long numero) {
		this.numero = numero;
		fecha = Dates.today();
	}

	public Factura(long numero, Date fecha) {
		this(numero);
		this.fecha = new Date(fecha.getTime());
	}

	public Factura(long numero, Collection<Averia> averias) {
		this(numero);
		addAverias(averias);
	}

	public Factura(long numero, Date fecha, Collection<Averia> averias) {
		this(numero, averias);
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	Set<Averia> _getAverias() {
		return averias;
	}

	public Long getNumero() {
		return numero;
	}

	public Date getFecha() {
		return new Date(fecha.getTime());
	}

	public double getImporte() {
		calcularImporte();
		return importe;
	}

	Set<Cargo> _getCargos() {
		return cargos;
	}

	public Set<Cargo> getCargos() {
		return cargos;
	}

	public double getIva() {
		return iva;
	}

	public FacturaStatus getStatus() {
		return status;
	}

	public Set<Averia> getAverias() {
		return new HashSet<>(averias);
	}

	/**
	 * Añade la averia a la factura y actualiza el importe e iva de la factura
	 * 
	 * @param averia
	 * @see Diagramas de estados en el enunciado de referencia
	 * @throws IllegalStateException
	 *             si la factura no está en estado SIN_ABONAR
	 */
	public void addAveria(Averia averia) {
		if (!status.equals(FacturaStatus.SIN_ABONAR)) {
			throw new IllegalStateException("La factura esta en un estado diferente a SIN ABONAR");
		}

		Association.Facturar.link(this, averia);
		averia.markAsInvoiced();
		calcularImporte();
	}

	private void addAverias(Collection<Averia> averias) {
		for (Averia averia : averias) {
			addAveria(averia);
		}
	}

	/**
	 * Calcula el importe de la avería y su IVA, teniendo en cuenta la fecha de
	 * factura
	 */
	void calcularImporte() {
		double importe = 0.0;
		for (Averia a : averias) {
			importe += a.getImporte();
		}
		this.iva = calcularIva(importe);
		this.importe = Round.twoCents(importe * iva);
	}

	private double calcularIva(double importe) {
		return Dates.isBefore(Dates.fromDdMmYyyy(1, 7, 2012), fecha) ? 1.21 : 1.18;
	}

	/**
	 * Elimina una averia de la factura, solo si está SIN_ABONAR y recalcula el
	 * importe
	 * 
	 * @param averia
	 * @see Diagramas de estados en el enunciado de referencia
	 * @throws IllegalStateException
	 *             si la factura no está en estado SIN_ABONAR
	 */
	public void removeAveria(Averia averia) {
		if (!status.equals(FacturaStatus.SIN_ABONAR)) {
			throw new IllegalStateException("No se ha podido eliminar la averia de la factura");
		}
		averia.markBackToFinished();
		Association.Facturar.unlink(this, averia);
		calcularImporte();
	}

	/**
	 * Marks the invoice as ABONADA, but
	 * 
	 * @see Diagramas de estados en el enunciado de referencia
	 * @throws IllegalStateException
	 *             if - Is already settled, or - the amounts paid with charges to
	 *             payment means does not cover the total of the invoice
	 */
	public void settle() {
		double importe = 0.0;
		for (Cargo cargo : cargos) {
			importe += cargo.getImporte();
		}

		if (status.equals(FacturaStatus.ABONADA) || this.importe == importe) {
			throw new IllegalStateException("La factura ya esta abonada");
		}
	}

	public boolean isSettled() {
		return getStatus().equals(FacturaStatus.ABONADA);
	}

	public void setFecha(Date fecha) {
		this.fecha = new Date(fecha.getTime());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Factura other = (Factura) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", importe="
				+ importe + ", iva=" + iva + ", status=" + status + ", averias="
				+ averias + ", cargos=" + cargos + "]";
	}
	
	

}
