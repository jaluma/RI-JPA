package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class Repuesto {
	private Long id;

	private String codigo;
	private String descripcion;
	private double precio;

	private Set<Sustitucion> sustituciones = new HashSet<>();

	/*
	 * Constructor usado por el mapper
	 */
	Repuesto() {
	}

	/**
	 * Constructor de repuesto
	 * @param codigo del repuesto
	 */
	public Repuesto(String codigo) {
		super();
		this.codigo = codigo;
	}

	/**
	 * Constructor de repuesto
	 * @param codigo del repuesto
	 * @param descripcion del repuesto
	 * @param precio del repuesto
	 */
	public Repuesto(String codigo, String descripcion, double precio) {
		this(codigo);
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	/**
	 * Getter de codigo
	 * @return codigo del repuesto
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Getter de descripcion
	 * @return descripcion del repuesto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Getter de precio
	 * @return precio del repuesto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Getter de Id
	 * @return id del repuesto
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Getter de sustitucion
	 * @return set de sustituciones
	 */
	public Set<Sustitucion> getSustituciones() {
		return new HashSet<>(sustituciones);
	}

	/**
	 * Getter de sustitucion usado por asociacion
	 * @return set de sustituciones
	 */
	Set<Sustitucion> _getSustituciones() {
		return sustituciones;
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
		Repuesto other = (Repuesto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Repuesto [codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", sustituciones="
				+ sustituciones + "]";
	}

}
