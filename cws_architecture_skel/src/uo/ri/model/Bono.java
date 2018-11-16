package uo.ri.model;

public class Bono extends MedioPago {

	private String codigo;
	private double disponible = 0.0;
	private String descripcion;

	/*
	 * Constructor usado por el mapper
	 */
	Bono() {
	}

	/**
	 * Constructor de bono
	 * @param codigo del bono
	 */
	public Bono(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Constructor de bono
	 * @param codigo del bono
	 * @param disponible del bono
	 */
	public Bono(String codigo, double disponible) {
		this(codigo);
		this.disponible = disponible;
	}

	/**
	 * Constructor de bono
	 * @param codigo del bono
	 * @param disponible del bono
	 * @param descripcion del bono
	 */
	public Bono(String codigo, double disponible, String descripcion) {
		this(codigo, disponible);
		this.descripcion = descripcion;
	}
	
	/**
	 * Getter de vehiculo
	 * @return el vehiculo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Getter de disponible
	 * @return el disponible
	 */
	public double getDisponible() {
		return disponible - acumulado;
	}

	/**
	 * Getter de descripcion
	 * @return la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Bono other = (Bono) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.model.MedioPago#toString()
	 */
	@Override
	public String toString() {
		return "Bono [codigo=" + codigo + ", disponible=" + disponible + ", descripcion=" + descripcion + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.model.MedioPago#actualizarImportes(double)
	 */
	@Override
	protected void actualizarImportes(double importe) {
		this.disponible += importe;
	}
}
