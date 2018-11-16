package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class TipoVehiculo {
	private Long id;

	private String nombre;
	private double precioHora;

	private Set<Vehiculo> vehiculos = new HashSet<>();

	/*
	 * Constructor usado por el mapper
	 */
	TipoVehiculo() {
	}

	/**
	 * Constructor de tipo de vehiculo
	 * @param nombre del tipo
	 */
	public TipoVehiculo(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Constructor de tipo de vehiculo
	 * @param nombre del tipo
	 * @param precioHora del tipo
	 */
	public TipoVehiculo(String nombre, double precioHora) {
		this(nombre);
		this.precioHora = precioHora;
	}

	/**
	 * Getter de vehiculo para la asociacion
	 * @return set de vehiculos
	 */
	Set<Vehiculo> _getVehiculo() {
		return vehiculos;
	}

	/**
	 * Getter de vehiculos
	 * @return set de vehiculos
	 */
	public Set<Vehiculo> getVehiculos() {
		return new HashSet<>(vehiculos);
	}

	/**
	 * Getter de ID
	 * @return id de vehiculo
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de nombre
	 * @return nombre de vehiculo
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre
	 * @param nombre de vehiculo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter de precio hora
	 * @return precio hora de vehiculo
	 */
	public double getPrecioHora() {
		return precioHora;
	}

	/**
	 * Setter de precio hora
	 * @param precio hora de vehiculo
	 */
	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		TipoVehiculo other = (TipoVehiculo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TipoVehiculo [nombre=" + nombre + ", precioHora=" + precioHora
				+ ", vehiculos=" + vehiculos + "]";
	}

}
