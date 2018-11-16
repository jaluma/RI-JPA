package uo.ri.model;

public class Sustitucion {
	private Long id;

	private Repuesto repuesto;
	private Intervencion intervencion;
	private int cantidad;

	/*
	 * Constructor usado por el mapper
	 */
	Sustitucion() {
	}

	/**
	 * Constructor de la sustitucion
	 * @param repuesto a cambiar
	 * @param intervencion que ha hecho la sustitucion
	 */
	public Sustitucion(Repuesto repuesto, Intervencion intervencion) {
		this.repuesto = repuesto;
		this.intervencion = intervencion;
		Association.Sustituir.link(intervencion, repuesto, this);
	}

	/**
	 * Constructor de la sustitucion
	 * @param repuesto a cambiar
	 * @param intervencion que ha hecho la sustitucion
	 * @param cantidad que ha habido que sustituir
	 */
	public Sustitucion(Repuesto repuesto, Intervencion intervencion, int cantidad) {
		this(repuesto, intervencion);
		setCantidad(cantidad);
	}

	/**
	 * Comprueba si la cantidad es correcta
	 * @param cantidad a sustituir
	 */
	private void checkCantidad(int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("Cantidad incorrecta");
		}
	}

	/**
	 * Getter de Id
	 * @return id de la sustitucion
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de Id
	 * @return id de la sustitucion
	 */
	public Repuesto getRepuesto() {
		return repuesto;
	}

	/**
	 * Getter de intervencion
	 * @return intervencion de la sustitucion
	 */
	public Intervencion getIntervencion() {
		return intervencion;
	}

	/**
	 * Getter de cantidad
	 * @return cantidad de la sustitucion
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Setter de cantidad
	 * @param cantidad a sustituir
	 */
	private void setCantidad(int cantidad) {
		checkCantidad(cantidad);
		this.cantidad = cantidad;
	}

	/**
	 * Setter usado por la asociacion (intervencin)
	 * @param intervencion a unir
	 */
	public void _setIntervencion(Intervencion intervencion) {
		this.intervencion = intervencion;
	}

	/**
	 * Setter usado por la asociacion (repuesto)
	 * @param repuesto a unir
	 */
	public void _setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intervencion == null) ? 0 : intervencion.hashCode());
		result = prime * result + ((repuesto == null) ? 0 : repuesto.hashCode());
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
		Sustitucion other = (Sustitucion) obj;
		if (intervencion == null) {
			if (other.intervencion != null)
				return false;
		} else if (!intervencion.equals(other.intervencion))
			return false;
		if (repuesto == null) {
			if (other.repuesto != null)
				return false;
		} else if (!repuesto.equals(other.repuesto))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sustitucion [repuesto=" + repuesto + ", intervencion="
				+ intervencion + ", cantidad=" + cantidad + "]";
	}

	/**
	 * Calcula el importe de la sustitucion
	 * @return importe total de la sustitucion
	 */
	public double getImporte() {
		return cantidad * repuesto.getPrecio();
	}
}
