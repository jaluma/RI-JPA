package uo.ri.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import uo.ri.model.types.AveriaStatus;

public class Averia {

	private Long id;

	private String descripcion;
	private Date fecha;
	private double importe = 0.0;
	private AveriaStatus status = AveriaStatus.ABIERTA;

	private Vehiculo vehiculo;
	private Factura factura;
	private Mecanico mecanico;
	private Set<Intervencion> intervenciones = new HashSet<>();

	/*
	 * Constructor usado por el mapper
	 */
	Averia() {
	}

	/**
	 * Constructor de averia
	 * @param vehiculo a vincular
	 */
	public Averia(Vehiculo vehiculo) {
		super();
		this.vehiculo = vehiculo;
		this.fecha = new Date();
		Association.Averiar.link(vehiculo, this);
	}

	/**
	 * Constructor de averia
	 * @param vehiculo a vincular
	 * @param descripcion descripcion de la averia
	 */
	public Averia(Vehiculo vehiculo, String descripcion) {
		this(vehiculo);
		this.descripcion = descripcion;
	}
	
	/**
	 * Getter usado en la asociacion
	 * @return set de intervenciones
	 */
	Set<Intervencion> _getIntervenciones() {
		return intervenciones;
	}

	/**
	 * Setter usado en la asociacion
	 */
	void _setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	/**
	 * Setter usado en la asociacion
	 */
	void _setFactura(Factura factura) {
		this.factura = factura;
	}

	/**
	 * Setter usado en la asociacion
	 */
	void _setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	/**
	 * Getter de ID
	 * @return la id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Getter de intervenciones
	 * @return set de intervenciones
	 */
	public Set<Intervencion> getIntervenciones() {
		return new HashSet<>(intervenciones);
	}

	/**
	 * Getter de descripcion
	 * @return la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Getter de fecha
	 * @return la fecha
	 */
	public Date getFecha() {
		return new Date(fecha.getTime());
	}

	/**
	 * Getter de importe
	 * @return el importe
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * Getter de estado de la averia
	 * @return es el estado de la averia
	 */
	public AveriaStatus getStatus() {
		return status;
	}

	/**
	 * Getter de vehiculo
	 * @return el vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * Getter de factura
	 * @return la factura
	 */
	public Factura getFactura() {
		return factura;
	}

	/**
	 * Getter de mecanico
	 * @return el mecanico
	 */
	public Mecanico getMecanico() {
		return mecanico;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		Averia other = (Averia) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Averia [descripcion=" + descripcion + ", fecha=" + fecha + ", importe=" + importe + ", status=" + status
				+ ", vehiculo=" + vehiculo + "]";
	}

	/**
	 * Asigna la averia al mecanico y esta queda marcada como ASIGNADA
	 * 
	 * @see Diagramas de estados en el enunciado de referencia
	 * @param mecanico
	 * @throws IllegalStateException
	 *             si - La avería no está en estado ABIERTA, o - La avería ya está
	 *             enlazada con otro mecánico
	 */
	public void assignTo(Mecanico mecanico) {
		if (!status.equals(AveriaStatus.ASIGNADA) && !status.equals(AveriaStatus.ABIERTA) || mecanico == null) {
			throw new IllegalStateException("No se puede asignar esta averia.");
		}

		if (status.equals(AveriaStatus.ABIERTA)) {
			Association.Asignar.link(mecanico, this);
			status = AveriaStatus.ASIGNADA;
		}
	}

	/**
	 * El mecánico da por finalizada esta avería, entonces se calcula el importe y
	 * pasa a TERMINADA
	 * 
	 * @see Diagramas de estados en el enunciado de referencia
	 * @throws IllegalStateException
	 *             si - La avería no está en estado ASIGNADA, o - La avería no está
	 *             enlazada con un mecánico
	 */
	public void markAsFinished() {

		if (status.equals(AveriaStatus.ASIGNADA) && mecanico != null) {
			calcularImporteAveria();
			Association.Asignar.unlink(mecanico, this);
			this.status = AveriaStatus.TERMINADA;
		} else {
			throw new IllegalStateException("No se puede marcar como finalizada esta averia.");

		}

	}

	private void calcularImporteAveria() {
		double importe = 0.0;
		for (Intervencion intervencion : intervenciones) {
			importe += intervencion.getImporte();
		}
		this.importe = importe;
	}

	/**
	 * Una averia en estado TERMINADA se puede asignar a otro mecánico (p.e., el
	 * primero no ha hecho bien la reparación), pero debe ser pasada a ABIERTA
	 * primero
	 * 
	 * @see Diagramas de estados en el enunciado de referencia
	 * @throws IllegalStateException
	 *             si - La avería no está en estado TERMINADA
	 */
	public void reopen() {
		if (status.equals(AveriaStatus.TERMINADA)) {
			status = AveriaStatus.ABIERTA;
		}
		// Se verifica que está en estado TERMINADA
		// Se pasa la averia a ABIERTA
	}

	/**
	 * Edte método se llama desde la factura al ejecutar factura.removeAveria()
	 * Retrocede la averia a TERMINADA
	 * 
	 * @see Diagramas de estados en el enunciado de referencia
	 * @throws IllegalStateException
	 *             si - La averia no está en estado FACTURADA, o - La avería aún
	 *             está enlazada con la factura
	 */
	public void markBackToFinished() {
		if (!status.equals(AveriaStatus.FACTURADA) || factura == null) {
			throw new IllegalStateException("No se puede cambiar a TERMINADA.");
		}
		status = AveriaStatus.TERMINADA;
	}

	/**
	 * Edte método se llama desde la factura al ejecutar factura.addAveria() Marca
	 * la averia como FACTURADA
	 * 
	 * @see Diagramas de estados en el enunciado de referencia
	 * @throws IllegalStateException
	 *             si - La averia no está en estado TERMINADA, o - La avería no está
	 *             enlazada con una factura
	 */
	public void markAsInvoiced() {
		if (!status.equals(AveriaStatus.TERMINADA) || factura == null) {
			throw new IllegalStateException("No se puede cambiar a TERMINADA.");
		}
		status = AveriaStatus.FACTURADA;
	}

	/**
	 * Desvincula la avería en estado ASIGNADA del mecánico y la pasa a ABIERTA
	 * 
	 * @see Diagramas de estados en el enunciado de referencia
	 * @throws IllegalStateException
	 *             si - La averia no está en estado ASIGNADA, o
	 */
	public void desassign() {
		if (status.equals(AveriaStatus.ASIGNADA)) {
			Association.Asignar.unlink(mecanico, this);
			status = AveriaStatus.ABIERTA;
		}
	}

}
