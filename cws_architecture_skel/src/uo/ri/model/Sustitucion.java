package uo.ri.model;

public class Sustitucion {
	private Long id;

	private Repuesto repuesto;
	private Intervencion intervencion;
	private int cantidad;

	Sustitucion() {
	}

	public Sustitucion(Repuesto repuesto, Intervencion intervencion) {
		this.repuesto = repuesto;
		this.intervencion = intervencion;
		Association.Sustituir.link(intervencion, repuesto, this);
	}

	public Sustitucion(Repuesto repuesto, Intervencion intervencion, int cantidad) {
		this(repuesto, intervencion);
		checkCantidad(cantidad);
		this.cantidad = cantidad;
	}

	private void checkCantidad(int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("Cantidad incorrecta");
		}
	}

	public Long getId() {
		return id;
	}

	public Repuesto getRepuesto() {
		return repuesto;
	}

	public Intervencion getIntervencion() {
		return intervencion;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intervencion == null) ? 0 : intervencion.hashCode());
		result = prime * result + ((repuesto == null) ? 0 : repuesto.hashCode());
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

	public void _setIntervencion(Intervencion intervencion) {
		this.intervencion = intervencion;
	}

	public void _setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public double getImporte() {
		return cantidad * repuesto.getPrecio();
	}

	@Override
	public String toString() {
		return "Sustitucion [repuesto=" + repuesto + ", intervencion="
				+ intervencion + ", cantidad=" + cantidad + "]";
	}

	
}
