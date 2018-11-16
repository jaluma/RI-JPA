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

	/*
	 * Constructor usado por el mapper
	 */
	Factura() {
	}

	/**
	 * Constructor de factura
	 * @param numero de la factura
	 */
	public Factura(long numero) {
		this.numero = numero;
		fecha = Dates.today();
	}

	/**
	 * Constructor de factura
	 * @param numero de la factura
	 * @param fecha de la factura
	 */
	public Factura(long numero, Date fecha) {
		this(numero);
		this.fecha = new Date(fecha.getTime());
	}

	/**
	 * Constructor de factura
	 * @param numero de la factura
	 * @param averias a facturar
	 */
	public Factura(long numero, Collection<Averia> averias) {
		this(numero);
		addAverias(averias);
	}

	/**
	 * Constructor de factura
	 * @param numero de la factura
	 * @param numero de la factura
	 * @param averias a facturar
	 */
	public Factura(long numero, Date fecha, Collection<Averia> averias) {
		this(numero, averias);
		this.fecha = fecha;
	}

	/**
	 * Getter de ID
	 * @return id de la factura
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de numero
	 * @return numero de la factura
	 */
	public Long getNumero() {
		return numero;
	}

	/**
	 * Getter de fecha
	 * @return fecha de la factura
	 */
	public Date getFecha() {
		return new Date(fecha.getTime());
	}

	/**
	 * Getter de importe
	 * @return importe de la factura
	 */
	public double getImporte() {
		calcularImporte();
		return importe;
	}

	/**
	 * Getter de cargos
	 * @return cargos de la factura
	 */
	public Set<Cargo> getCargos() {
		return cargos;
	}

	/**
	 * Getter del iva
	 * @return iva de la factura
	 */
	public double getIva() {
		return iva;
	}

	/**
	 * Getter de estado
	 * @return estado de la factura
	 */
	public FacturaStatus getStatus() {
		return status;
	}

	/**
	 * Getter de averias
	 * @return averias de la factura
	 */
	public Set<Averia> getAverias() {
		return new HashSet<>(averias);
	}
	
	/**
	 * Setter de fecha
	 * @param fecha de la factura
	 */
	public void setFecha(Date fecha) {
		this.fecha = new Date(fecha.getTime());
	}	
	
	/**
	 * Getter de cargos usado por la asociacion
	 * @return cargos de la factura
	 */
	Set<Cargo> _getCargos() {
		return cargos;
	}
	
	/**
	 * Getter de averias usado por la asociacion
	 * @return averias de la factura
	 */
	Set<Averia> _getAverias() {
		return averias;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", importe="
				+ importe + ", iva=" + iva + ", status=" + status + ", averias="
				+ averias + ", cargos=" + cargos + "]";
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

	/**
	 * Calcula el iva del importe segun el año
	 * @param importe a calcular
	 * @return valor del iva segun el importe y la fecha
	 */
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

		if (isSettled() || this.importe == importe) {
			throw new IllegalStateException("La factura ya esta abonada");
		}
	}

	/**
	 * Devuelve si una factura esta abonada
	 * @return true si esta abonada, false en otro caso
	 */
	public boolean isSettled() {
		return getStatus().equals(FacturaStatus.ABONADA);
	}

}
